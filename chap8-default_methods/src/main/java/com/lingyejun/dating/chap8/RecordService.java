package com.lingyejun.dating.chap8;

/**
 * @Author: lingyejun
 * @Date: 2019/12/22
 * @Describe:
 * @Modified By:
 */
public interface RecordService {

    void start();

    void pause();

    default void stop() {
        System.out.println("录音笔--停止！！！");
    }
}
