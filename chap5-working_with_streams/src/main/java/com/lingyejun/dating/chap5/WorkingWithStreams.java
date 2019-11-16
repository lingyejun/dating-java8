package com.lingyejun.dating.chap5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: lingyejun
 * @Date: 2019/11/16
 * @Describe:
 * @Modified By:
 */
public class WorkingWithStreams {

    public static List<Worker> initWorkerList() {

        Worker worker1 = new Worker("老王", "男", Boolean.FALSE, 10000, Arrays.asList(new Car("宝马"), new Car("路虎")), Arrays.asList(new House("南山区")));

        Worker worker2 = new Worker("小李", "男", Boolean.FALSE, 8000, Arrays.asList(new Car("奔驰")), null);

        Worker worker3 = new Worker("小花", "女", Boolean.FALSE, 6000, null, null);

        Worker worker4 = new Worker("阿静", "女", Boolean.FALSE, 5000, Arrays.asList(new Car("奔驰")), Arrays.asList(new House("福田区")));

        Worker worker5 = new Worker("小赵", "男", Boolean.TRUE, 10000, null, Arrays.asList(new House("宝安区")));

        Worker worker6 = new Worker("小美", "女", Boolean.TRUE, 13000, Arrays.asList(new Car("大众")), Arrays.asList(new House("宝安区"), new House("龙岗区")));

        return Arrays.asList(worker1, worker2, worker3, worker4, worker5, worker6);
    }

    public static void main(String[] args) {

        List<Worker> workerList = initWorkerList();

        // 筛选和切片 filter、distinct、limit、skip

        // filter
        List<Worker> worker1 = workerList.stream().filter(worker -> "男".equals(worker.getSex())).collect(Collectors.toList());
        List<Worker> worker2 = workerList.stream().filter(worker -> worker.getMarried()).collect(Collectors.toList());

        // distinct
        List<Integer> intList = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        List<Integer> intList1 = intList.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
        List<Integer> workers3 = workerList.stream().map(worker -> worker.getSalary()).distinct().collect(Collectors.toList());

        // limit
        List<Worker> workers4 = workerList.stream().limit(3).collect(Collectors.toList());
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(5);
        set1.add(7);
        set1.add(1);
        set1.stream().limit(2).forEach(i -> System.out.println(i));

        // skip
        List<Worker> workers5 = workerList.stream().skip(3).collect(Collectors.toList());

        // 映射 map、flatMap

        // map
        List<String> worker6 = workerList.stream().map(Worker::getName).collect(Collectors.toList());
        List<String> worker7 = workerList.stream().map(Worker::getSex).distinct().collect(Collectors.toList());

        List<Integer> worker8 = workerList.stream().map(Worker::getName).map(name -> name.length()).collect(Collectors.toList());

        // flatMap
        List<String> wordList = Arrays.asList("Hello", "World");
        // 得到一个字符列表，且没有重复字符
        List<String[]> word1 = wordList.stream().map(str -> str.split("")).collect(Collectors.toList());
        List<String[]> word2 = wordList.stream().map(str -> str.split("")).distinct().collect(Collectors.toList());

        Stream<Stream<String>> stream1 = wordList.stream().map(str -> str.split("")).map(Arrays::stream);
        Stream<String> stream2 = wordList.stream().map(str -> str.split("")).flatMap(Arrays::stream);
        List<String> word3 = stream2.distinct().collect(Collectors.toList());

        // 获取工人所拥有的汽车，然后去重得到不重复的汽车品牌列表
        List<List<Car>> workers9 = workerList.stream().map(worker -> worker.getCarList()).collect(Collectors.toList());
        List<Car> worker10 = workerList.stream().map(worker -> worker.getCarList()).filter(list -> list != null).flatMap(list -> list.stream()).collect(Collectors.toList());
        List<String> worker11 = workerList.stream().map(worker -> worker.getCarList()).filter(list -> list != null).flatMap(list -> list.stream()).map(Car::getBrand).distinct().collect(Collectors.toList());
        List<String> worker12 = workerList.stream().map(Worker::getHouseList).filter(Objects::nonNull).flatMap(Collection::stream).map(House::getAddress).distinct().collect(Collectors.toList());

        // 查找匹配 allMatch、anyMatch、noneMatch、findFirst、findAny

        // allMatch
        boolean allMatch = workerList.stream().allMatch(worker -> worker.getSex().equals("男"));
        System.out.println(allMatch);

        // anyMatch
        System.out.println(workerList.stream().anyMatch(worker -> !worker.getMarried()));
        List<String> list = workerList.stream().filter(worker -> !worker.getMarried()).map(Worker::getName).collect(Collectors.toList());

        // noneMatch
        System.out.println(workerList.stream().noneMatch(worker -> worker.getSalary() > 20000));

        // findAny
        Optional<Worker> optionalWorker = workerList.stream().filter(worker -> !worker.getMarried()).findAny();

        // findFirst

        // 找一个未婚的女性中的第一个
        Optional<Worker> optionalWorker1 = workerList.stream().filter(worker -> worker.getSex().equals("女") && !worker.getMarried()).findFirst();

        // 归约 reduce
        List<Integer> integerList = Arrays.asList(1, 2, 4, 5, 7, 8);
        Integer sum = integerList.stream().reduce(1, (a, b) -> a * b);
        System.out.println(sum);

        // 找到工人里面工资最多是多少
        Optional<Integer> maxSalary = workerList.stream().map(Worker::getSalary).reduce(Integer::max);
        System.out.println(maxSalary.get());
        Optional<Integer> minSalary = workerList.stream().map(Worker::getSalary).reduce(Integer::min);
        System.out.println(minSalary.get());

    }
}
