package com.lingyejun.dating.chap3;

import com.lingyejun.dating.chap2.Phone;
import com.lingyejun.dating.chap2.PhonePredicate;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: lingyejun
 * @Date: 2019/10/28
 * @Describe:
 * @Modified By:
 */
public class MethodReference {

    public static void main(String[] args) {
        Function<String, Integer> function = (String s) -> Integer.parseInt(s);
        Integer a = function.apply("15");
        System.out.println(a);

        // 指向静态方法的方法引用(例如Integer的parseInt方法，写作Integer::parseInt)。
        Function<String, Integer> function1 = Integer::parseInt;
        System.out.println(function1.apply("20"));

        // 指向任意类型实例方法的方法引用
        Function<String, Integer> function2 = (String s) -> s.length();
        System.out.println(function2.apply("abc"));
        Function<String, Integer> function3 = String::length;
        System.out.println(function3.apply("abcd"));

        // 指向现有对象的实例方法的方法引用
        // 调用外部的对象
        PhonePredicate phonePredicate = (Phone phone) -> true;
        Function<Phone, Boolean> function4 = (Phone phone) -> phonePredicate.test(phone);
        System.out.println(function4.apply(new Phone()));
        Function<Phone, Boolean> function5 = phonePredicate::test;
        System.out.println(function5.apply(new Phone()));

        Supplier<Phone> supplier = Phone::new;
        Function<Integer,Phone> function6 = Phone::new;
    }
}
