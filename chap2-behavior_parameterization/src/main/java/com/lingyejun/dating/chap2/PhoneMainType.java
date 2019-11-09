package com.lingyejun.dating.chap2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: lingyejun
 * @Date: 2019/10/27
 * @Describe: 
 * @Modified By:
 */
public class PhoneMainType<T> {

    public List<T> userPredicateImpl(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();

        for (T t : list) {
            if (predicate.test(t)) {
                filteredList.add(t);
            }
        }
        return filteredList;
    }

    public static void main(String[] args) {
        PhoneMainType<Phone> phoneMainType = new PhoneMainType();

        List<Phone> filteredList = phoneMainType.userPredicateImpl(PhoneMain.initPhoneList(),(Phone phone) -> "64GB".equals(phone.getSpec()));

        System.out.println(filteredList.size());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("abc");
            }
        });

        Thread thread1 = new Thread(() -> {
            System.out.println("bcd");
        });

        thread1.start();
    }
}
