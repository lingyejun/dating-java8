package com.lingyejun.dating.chap7;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * @Author: lingyejun
 * @Date: 2019/12/15
 * @Describe:
 * @Modified By:
 */
public class ParallelMain {


    public static void main(String[] args) {
        Long start = Instant.now().toEpochMilli();
        // 求0-10000000所有数据的和
        Long sum = 0L;
        for (long i = 0; i <= 10000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Long end = Instant.now().toEpochMilli();
        System.out.println("for循环单线程执行 耗费时间：" + (end - start));

        // 获取Jvm最大的可用线程数
        System.out.println(Runtime.getRuntime().availableProcessors());

        Long start1 = Instant.now().toEpochMilli();

        // 要处理的数据量的太小
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long sum1 = forkJoinPool.invoke(new CalculatorSumTask(0L,10000000000L));
        System.out.println(sum1);

        Long end1 = Instant.now().toEpochMilli();
        System.out.println("fork join 并行执行 耗费时间：" + (end1 - start1));

        Long start2 = Instant.now().toEpochMilli();

        Long sum2 = LongStream.rangeClosed(0L,10000000000L).parallel().reduce(0L,Long::sum);
        System.out.println(sum2);

        Long end2 = Instant.now().toEpochMilli();
        System.out.println("java8 parallel 并行执行 耗费时间：" + (end2 - start2));
    }
}
