package com.lingyejun.dating.chap3;

import java.util.function.*;

/**
 * @Author: lingyejun
 * @Date: 2019/10/27
 * @Describe:
 * @Modified By:
 */
public class FunctionLearn {

    /**
     * Function
     */
    public static void learnFunction() {
        Function<String, String> functionStr = (String s) -> s + "。";
        System.out.println(functionStr.apply("Hello World"));

        Function<Integer, Integer> function1 = (Integer a) -> a + 2;
        Integer x = function1.apply(5);
        System.out.println(x);
        Function<Integer, Integer> function2 = (Integer a) -> a * 2;

        // 组合两个Function函数，a * 2 compose a+2 = (a+2) * 2
        Function<Integer, Integer> function3 = function2.compose(function1);
        System.out.println("Function3 : " + function3.apply(20));

        // 先后顺序拼接两个Function a *2 andThen a+2 = (a*2) + 2
        Function<Integer, Integer> function4 = function2.andThen(function1);
        System.out.println("Function4 : " + function4.apply(15));

        // 输入啥返回啥
        Function.identity();
    }

    /**
     * Consumer
     */
    public static void learnConsumer() {
        Consumer<Integer> consumer1 = (Integer a) -> System.out.println("Consumer 1 : " + a);
        // 吃掉外部传进来的T，在方法内部消化掉，什么也不返回
        consumer1.accept(100);
        Consumer<Integer> consumer2 = (Integer a) -> System.out.println("Consumer 2 : " + a + "Done");
        Consumer<Integer> consumer3 = consumer1.andThen(consumer2);
        consumer3.accept(10);
        consumer1.andThen(consumer2).accept(10);
    }

    /**
     * Supplier
     */
    public static void learnSupplier() {
        // 无中生有，凭空生成一个东西出来
        Supplier<Integer> supplier = () -> 10;
        Integer a = supplier.get();
        System.out.println(a);
    }

    /**
     * Predicate
     */
    public static void learnPredicate() {
        Predicate<Integer> predicate1 = (Integer a) -> a > 10;
        System.out.println(predicate1.test(20));

        Predicate<Integer> predicate2 = (Integer a) -> a < 20;
        // and 与操作
        Predicate<Integer> predicate3 = predicate1.and(predicate2);
        System.out.println(predicate3.test(9));

        Predicate<Integer> predicate4 = (Integer a) -> a > 8;
        // or 或操作
        System.out.println(predicate1.or(predicate4).test(7));

        // ! 取反操作
        System.out.println(predicate4.negate().test(7));
    }

    /**
     * BiFunction
     */
    public static void learnBiFunction() {
        BiFunction<Integer, Integer, Integer> biFunction1 = (Integer a, Integer b) -> a + b;
        System.out.println(biFunction1.apply(10, 15));
        Function<Integer, Integer> biFunction2 = (Integer a) -> a * 2;
        System.out.println(biFunction1.andThen(biFunction2).apply(10, 15));
    }

    /**
     * BiConsumer
     */
    public static void learnBiConsumer() {
        BiConsumer<Integer, Integer> biConsumer1 = (Integer a, Integer b) -> System.out.println(a + b);
        biConsumer1.accept(1, 2);
        BiConsumer<Integer, Integer> biConsumer2 = (Integer a, Integer b) -> System.out.println(a * b);
        biConsumer1.andThen(biConsumer2).accept(1, 2);
    }

    /**
     * BiPredicate
     */
    public static void learnBiPredicate() {
        BiPredicate<Integer, Integer> biPredicate1 = (Integer a, Integer b) -> a > 10 && b < 15;
        System.out.println(biPredicate1.test(11, 14));
        BiPredicate<Integer, Integer> biPredicate2 = (Integer a, Integer b) -> a > 13;

        System.out.println(biPredicate1.and(biPredicate2).test(11, 14));
        System.out.println(biPredicate1.or(biPredicate2).test(11, 14));
        System.out.println(biPredicate2.negate().test(11, 14));
    }

    public static void main(String[] args) {

        learnFunction();
        learnConsumer();
        learnSupplier();
        learnPredicate();
        learnBiFunction();
        learnBiConsumer();
        learnBiPredicate();
    }
}
