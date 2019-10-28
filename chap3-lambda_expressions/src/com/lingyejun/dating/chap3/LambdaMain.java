package com.lingyejun.dating.chap3;

import com.lingyejun.dating.chap2.Phone;
import com.lingyejun.dating.chap2.PhoneMain;
import com.lingyejun.dating.chap2.PhonePredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lingyejun
 * @Date: 2019/10/27
 * @Describe:
 * @Modified By:
 */
public class LambdaMain {

    public static void processRun(Runnable runnable) {
        runnable.run();
    }

    public static void main(String[] args) {
        /*//(parameters) -> expression
        (Phone phone) -> "红色".equals(phone.getColor())
        //(parameters) -> { statements; }
        (Phone phone) -> {return "红色".equals(phone.getColor());}

        () -> new Phone()

        (Phone phone) -> {
            System.out.println(phone.getSpec());
        }*/
        // Lambda就是函数式接口的一个具体实现的实例
        PhonePredicate phonePredicate = new SourcePhonePredicateImpl();
        PhonePredicate lambdaType = (Phone phone) -> {
            System.out.println("This is phone");
            return true;
        };

        if (lambdaType.test(new Phone())) {
            System.out.println("OK");
        }

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable By 匿名类！");
            }
        };

        Runnable runnable2 = () -> System.out.println("Runnable By Lambda");

        processRun(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable By 匿名类！");
            }
        });

        processRun(() -> {
            System.out.println("Runnable By Lambda");
            return;
        });

        // 寻找手机名称为iphone11的手机列表

        // 1.记得行为参数化
        ProcessFind processFind = new ProcessFind() {
            @Override
            public List<Phone> queryPhoneList(List<Phone> list) {
                List<Phone> phoneList = new ArrayList<>();
                for (Phone phone : list) {
                    if ("iPhone 11 Pro".equals(phone.getProductName())) {
                        phoneList.add(phone);
                    }
                }
                return phoneList;
            }
        };

        // 2.使用函数式接口来传递行为 -> 将行为进行抽象，提取到ProcessFind接口当中

        // 3.执行一个行为 -> 在外部代码中执行函数式接口当中的抽象方法

        // 4.传递Lambda
        ProcessFind processFindLambda = (List<Phone> list) -> {
            List<Phone> phoneList = new ArrayList<>();
            for (Phone phone : list) {
                if ("iPhone 11 Pro".equals(phone.getProductName())) {
                    phoneList.add(phone);
                }
            }
            return phoneList;
        };

        System.out.println(processFindLambda.queryPhoneList(PhoneMain.initPhoneList()).size());
    }

    public static List<Phone> getPhoneListByName(List<Phone> list) {
        List<Phone> phoneList = new ArrayList<>();
        for (Phone phone : list) {
            if ("iPhone 11 Pro".equals(phone.getProductName())) {
                phoneList.add(phone);
            }
        }
        return phoneList;
    }
}
