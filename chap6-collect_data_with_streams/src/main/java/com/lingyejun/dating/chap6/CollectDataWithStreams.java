package com.lingyejun.dating.chap6;

import com.lingyejun.dating.chap5.Worker;
import com.lingyejun.dating.chap5.WorkingWithStreams;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


/**
 * @Author: lingyejun
 * @Date: 2019/11/24
 * @Describe:
 * @Modified By:
 */
public class CollectDataWithStreams {

    private static List<Worker> workerList = WorkingWithStreams.initWorkerList();

    public static void main(String[] args) {
        List<String> nameList = workerList.stream().map(Worker::getName).collect(Collectors.toList());
        System.out.println(nameList);
        List<String> lingyeNameList = workerList.stream().map(Worker::getName).collect(new LingyeToListCollectorImpl<String>());
        System.out.println(lingyeNameList);
        List<String> threeParamsNameList = workerList.stream().map(Worker::getName).collect(
                () -> new ArrayList<String>(),
                (r, t) -> r.add(t),
                (list1, list2) -> {
                    list1.addAll(list2);
                }
        );
        System.out.println(threeParamsNameList);
        // 将List<String>转化成String结果
        List<String> stringList = Arrays.asList("abc", "def", "hhh");
        String concatString = stringList.stream().collect(
                () -> new StringBuilder(),
                (stringBuilder, string) -> stringBuilder.append(string),
                (sb1, sb2) -> sb1.append(sb2)
        ).toString();
        System.out.println(concatString);

        // 求数量 Collectors.counting()
        Long workerCount = workerList.stream().collect(Collectors.counting());
        System.out.println(workerCount);
        // 查找流中最大值和最小值 Collectors.maxBy Collectors.minBy
        Optional<Worker> maxSalaryWorker = workerList.stream().collect(Collectors.maxBy(Comparator.comparing(Worker::getSalary)));
        System.out.println(maxSalaryWorker.get().getName() + " " + maxSalaryWorker.get().getSalary());
        Optional<Worker> minSalaryWorker = workerList.stream().collect(Collectors.minBy(Comparator.comparing(Worker::getSalary)));
        System.out.println(minSalaryWorker.get().getName() + " " + minSalaryWorker.get().getSalary());
        // 汇总
        // 求和 Collectors.summingInt
        Integer summarySalaryInt = workerList.stream().collect(Collectors.summingInt(Worker::getSalary));
        System.out.println(summarySalaryInt);
        Double summarySalaryDouble = workerList.stream().collect(Collectors.summingDouble(Worker::getSalary));
        System.out.println(summarySalaryDouble);
        // 求平均值 Collectors.averagingInt
        Double averageSalaryInt = workerList.stream().collect(Collectors.averagingInt(Worker::getSalary));
        System.out.println(averageSalaryInt);
        // 求汇总结果 Collectors.summarizingInt
        IntSummaryStatistics intSummaryStatistics = workerList.stream().collect(Collectors.summarizingInt(Worker::getSalary));
        System.out.println(intSummaryStatistics);
        // 连接字符串 Collectors.joining
        String joiningName = workerList.stream().map(Worker::getName).collect(Collectors.joining());
        System.out.println(joiningName);
        String joiningNameByChar = workerList.stream().map(Worker::getName).collect(Collectors.joining(","));
        System.out.println(joiningNameByChar);
        // 广义的归约汇总
        // counting -> reduce
        Long reduceSum = workerList.stream().collect(Collectors.reducing(0L, woker -> 1L, Long::sum));
        System.out.println(reduceSum);
        // sum -> reduce
        Integer reduceIntegerSum = workerList.stream().collect(Collectors.reducing(0, Worker::getSalary, Integer::sum));
        System.out.println(reduceIntegerSum);
        // joining -> reduce
        String reduceJoiningName = workerList.stream().collect(Collectors.reducing("", Worker::getName, (s1, s2) -> s1 + s2));
        System.out.println(reduceJoiningName);
        // 分组
        // 按照性别得到工人列表
        Map<String, List<Worker>> map1 = workerList.stream().collect(groupingBy(Worker::getSex));
        // 按性别分组得到工人名称列表
        Map<String, List<String>> map2 = workerList.stream().collect(groupingBy(Worker::getSex, mapping(Worker::getName, toList())));
        System.out.println(map2);
        // 按性别分组得到人数有多少
        Map<String, Long> map3 = workerList.stream().collect(groupingBy(Worker::getSex, counting()));
        System.out.println(map3);
        // 按性别分组求各自的薪资平均值
        Map<String, Double> map4 = workerList.stream().collect(groupingBy(Worker::getSex, averagingInt(Worker::getSalary)));
        System.out.println(map4);
        // 二级分组
        // 按性别分完组后再按照婚嫁与否进行分组
        Map<String,Map<Boolean,List<String>>> map5 = workerList.stream().collect(groupingBy(Worker::getSex,groupingBy(Worker::getMarried,mapping(Worker::getName,toList()))));
        System.out.println(map5);
        // 分组后求最大最小值
        // 性别分组完毕后求各自的最大和最小值
        Map<String,Worker> maxBySexWorker = workerList.stream().collect(groupingBy(Worker::getSex,collectingAndThen(maxBy(Comparator.comparing(Worker::getSalary)),Optional::get)));
        System.out.println(maxBySexWorker);
        Map<String,Worker> minBySexWorker = workerList.stream().collect(groupingBy(Worker::getSex,collectingAndThen(minBy(Comparator.comparing(Worker::getSalary)),Optional::get)));
        System.out.println(minBySexWorker);
        // 分区
        // 按婚嫁进行分区
        Map<Boolean,List<Worker>> par1 = workerList.stream().collect(partitioningBy(Worker::getMarried));
        System.out.println(par1);
        // 按工资分水岭1w进行分区
        Map<Boolean,List<String>> par2 = workerList.stream().collect(partitioningBy(worker -> worker.getSalary() > 10000, mapping(Worker::getName, toList())));
        System.out.println(par2);

        Comparator<Worker> byName = Comparator.comparing(Worker::getName,Comparator.nullsFirst(Comparator.naturalOrder()));
        Comparator<Worker> bySex = Comparator.comparing(Worker::getSex);

        Comparator<Worker> comparator3 = bySex.thenComparing(byName);

        List<Worker> list = workerList.stream().sorted(comparator3).collect(Collectors.toList());
        System.out.println(list);

    }
}
