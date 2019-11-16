package com.lingyejun.dating.chap4;

import com.lingyejun.dating.chap2.Phone;
import com.lingyejun.dating.chap2.PhoneMain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: lingyejun
 * @Date: 2019/11/10
 * @Describe:
 * @Modified By:
 */
public class Chap4Learn {

    // 按价格排序后得到手机名称列表
    public static List<String> convertSortNameList() {

        // 先拿到原始的手机集合
        List<Phone> phoneList = PhoneMain.initPhoneList();

        // 按价格排序
        phoneList.sort(new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });

        // 取出对应的手机名称
        List<String> nameList = new ArrayList<>();

        for (Phone phone : phoneList) {
            nameList.add(phone.getProductName());
        }

        return nameList;
    }

    // 按价格排序后得到手机名称列表,for,for-each
    public static List<String> convertByStream() {
        return PhoneMain.initPhoneList().
                stream().
                filter(phone -> Objects.equals(phone.getColor(), "银色")).
                sorted(Comparator.comparing(Phone::getPrice)).
                map(Phone::getProductName).
                collect(Collectors.toList());
    }

    public static void testExecuteOnce() {
        Stream<Phone> phoneStream = PhoneMain.initPhoneList().stream();
        phoneStream.forEach(phone -> {
            System.out.println(phone.getPrice());
        });
        // 只能遍历和消费一次
        phoneStream.forEach(phone1 -> {
            System.out.println(phone1.getPrice());
        });
    }

    public static void differentFor() {
        List<Phone> phoneList = PhoneMain.initPhoneList();
        List<Integer> phonePriceList = new ArrayList<>();

        // 使用for-each循环外部迭代
        phoneList.forEach(phone -> {
            phonePriceList.add(phone.getPrice());
        });

        // 使用其背后的迭代器做外部迭代
        Iterator<Phone> iterator = phoneList.iterator();
        while (iterator.hasNext()) {
            Phone phone = iterator.next();
            phonePriceList.add(phone.getPrice());
        }

        // 使用流做内部迭代
        List<Integer> priceList = phoneList.
                stream().
                map(Phone::getPrice).
                collect(Collectors.toList());

    }

    /**
     * 流操作的类型
     */
    public static void streamOperatorType() {
        List<Phone> phoneList = PhoneMain.initPhoneList();
        // 手机列表中价格排序前两个的手机名称
        List<String> phoneNameList = phoneList.stream()

                .sorted(Comparator.comparing(Phone::getPrice).reversed())
                .limit(2)
                .map(Phone::getProductName)

                .collect(Collectors.toList());

        phoneNameList.forEach(name -> {
            System.out.println(name);
        });
    }

    public static void streamJoin() {
        List<String> nameList = PhoneMain.initPhoneList().stream()
                .filter(phone -> {
                    System.out.println("filter: " + phone.getProductName());
                    return Objects.equals(phone.getColor(),"银色");
                })
                .map(phone -> {
                    System.out.println("map: " + phone.getProductName());
                    return phone.getProductName();
                }).collect(Collectors.toList());

        System.out.println(nameList);
    }

    public static void main(String[] args) {
        //List<String> nameList = convertSortNameList();
//        List<String> nameList = convertByStream();
////        for (String s : nameList) {
////            System.out.print(s + " ");
////        }

        // testExecuteOnce();
        //streamOperatorType();
        streamJoin();
    }
}
