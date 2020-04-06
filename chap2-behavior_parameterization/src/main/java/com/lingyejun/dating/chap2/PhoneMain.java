package com.lingyejun.dating.chap2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: lingyejun
 * @Date: 2019/10/27
 * @Describe:
 * @Modified By:
 */
public class PhoneMain {

    /**
     * 初始化手机列表
     *
     * @return
     */
    public static List<Phone> initPhoneList() {
        List<Phone> phones = new ArrayList<>();
        Phone phone1 = new Phone(1, "iPhone 11 Pro", "银色", "64GB", 8699);
        Phone phone2 = new Phone(2, "iPhone 11 Pro", "银色", "64GB", 8700);
        Phone phone3 = new Phone(3, "iPhone 11 Pro Max", "银色", "64GB", 8900);

        phones.add(phone1);
        phones.add(phone2);
        phones.add(phone3);

        return phones;
    }

    /**
     * 我想看看颜色是深空灰色的手机有哪些
     *
     * @param phoneList
     * @return
     */
    public static List<Phone> filterGrayPhoneList(List<Phone> phoneList) {
        List<Phone> filteredPhones = new ArrayList<>();

        for (Phone phone : phoneList) {
            if ("深空灰色".equals(phone.getColor())) {
                filteredPhones.add(phone);
            }
        }
        return filteredPhones;
    }

    /**
     * 按照策略进行筛选
     *
     * @param phoneList
     * @param phonePredicate
     * @return
     */
    public static List<Phone> userPredicateImpl(List<Phone> phoneList, PhonePredicate phonePredicate) {
        List<Phone> filteredPhones = new ArrayList<>();

        for (Phone phone : phoneList) {
            if (phonePredicate.test(phone)) {
                filteredPhones.add(phone);
            }
        }
        return filteredPhones;
    }

    /**
     * 过滤出来金色的手机
     *
     * @param phoneList
     * @return
     */
    public static List<Phone> filterGoldenPhoneList(List<Phone> phoneList) {
        List<Phone> filteredPhones = new ArrayList<>();

        for (Phone phone : phoneList) {
            if ("金色".equals(phone.getColor())) {
                filteredPhones.add(phone);
            }
        }
        return filteredPhones;
    }

    /**
     * 按颜色过滤
     *
     * @param phoneList
     * @param color
     * @return
     */
    public static List<Phone> filterPhoneListByColor(List<Phone> phoneList, String color, Integer price, boolean choseFlg) {
        List<Phone> filteredPhones = new ArrayList<>();

        for (Phone phone : phoneList) {
            if (choseFlg) {
                if (Objects.equals(color, phone.getColor())) {
                    filteredPhones.add(phone);
                }
            } else {
                if (phone.getPrice() > price) {
                    filteredPhones.add(phone);
                }
            }

        }
        return filteredPhones;
    }

    /**
     * 按颜色过滤
     *
     * @param phoneList
     * @param color
     * @return
     */
    public static List<Phone> filterPhoneListByColor(List<Phone> phoneList, String color) {
        List<Phone> filteredPhones = new ArrayList<>();

        for (Phone phone : phoneList) {
            if (Objects.equals(color, phone.getColor())) {
                filteredPhones.add(phone);
            }
        }
        return filteredPhones;
    }

    /**
     * 按价格过滤
     *
     * @param phoneList
     * @param price
     * @return
     */
    public static List<Phone> filterPhoneListByColor(List<Phone> phoneList, int price) {
        List<Phone> filteredPhones = new ArrayList<>();

        for (Phone phone : phoneList) {
            if (phone.getPrice() > price) {
                filteredPhones.add(phone);
            }
        }
        return filteredPhones;
    }

    public static void main(String[] args) {
        List<Phone> filteredGrayList = filterGrayPhoneList(initPhoneList());
        List<Phone> filteredGoldenList = filterGoldenPhoneList(initPhoneList());
        System.out.println("深空灰色 : " + filteredGrayList.size());
        System.out.println("金色的手机 : " + filteredGoldenList.size());

        System.out.println("filterPhoneListBy 深空灰色 " + filterPhoneListByColor(initPhoneList(), "深空灰色", null, true).size());
        System.out.println("filterPhoneListBy 银色 " + filterPhoneListByColor(initPhoneList(), "银色", null, true).size());

        System.out.println("filterPhoneListBy Price " + filterPhoneListByColor(initPhoneList(), null, 10000, false).size());

        System.out.println("filter By Predicate : " + userPredicateImpl(initPhoneList(), new PhonePricePredicate()).size());

        System.out.println("filter By 匿名类 : " + userPredicateImpl(initPhoneList(), new PhonePredicate() {
            @Override
            public boolean test(Phone phone) {
                return "暗夜绿色".equals(phone.getColor());
            }
        }).size());

        System.out.println("filter By Lambda : " +
                userPredicateImpl(initPhoneList(),
                        (Phone phone) -> "暗夜绿色".equals(phone.getColor())
                ).size());

        List<Phone> sortedList = initPhoneList();

        sortedList.sort((Phone phone1, Phone phone2) -> phone1.getPrice().compareTo(phone2.getPrice()));
    }
}
