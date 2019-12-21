package com.lingyejun.dating.chap7;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * 模拟发短信
 *
 * @Author: lingyejun
 * @Date: 2019/12/15
 * @Describe:
 * @Modified By:
 */
public class SendSmsTask extends RecursiveAction {

    private List<String> phoneList;

    private String smsText;

    private static final Integer THRESHOLD = 1000;

    public SendSmsTask(List<String> phoneList, String smsText) {
        this.phoneList = phoneList;
        this.smsText = smsText;
    }

    private void send(String phoneNumber, String smsText) {
        try {
            Thread.sleep(10);
            System.out.println("发送：" + phoneNumber + " 内容：" + smsText);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对一批手机号进行发短信处理
     */
    @Override
    protected void compute() {
        int batchSize = phoneList.size();
        if (batchSize <= 1000) {
            for (String number : phoneList) {
                send(number, smsText);
            }
        } else {
            // 拆的逻辑和如何拆分由自己来定义
            int middle = phoneList.size() / 2;

            List<String> leftList = phoneList.subList(0, middle);
            List<String> rightList = phoneList.subList(middle, phoneList.size());

            SendSmsTask leftTask = new SendSmsTask(leftList,smsText);
            SendSmsTask rightTask = new SendSmsTask(rightList,smsText);

            leftTask.fork();
            rightTask.fork();

            // 下面这两步骤可以省略
            leftTask.join();
            rightTask.join();
        }
    }
}
