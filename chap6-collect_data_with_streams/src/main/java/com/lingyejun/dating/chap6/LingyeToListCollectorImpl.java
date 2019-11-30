package com.lingyejun.dating.chap6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * toList
 *
 * @Author: lingyejun
 * @Date: 2019/11/30
 * @Describe: 
 * @Modified By:
 */
public class LingyeToListCollectorImpl<T> implements Collector<T, List<T>,List<T>> {

    /**
     * 初始化一个中间状态的结果容器
     *
     * @return
     */
    @Override
    public Supplier<List<T>> supplier() {
        return () -> new ArrayList<>();
    }

    /**
     * 遍历流中的元素，把元素添加到中间状态的结果容器中
     *
     * @return
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return (a, t) -> a.add(t);
    }

    /**
     * 并行化归约过程中进行合并操作
     *
     * @return
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    /**
     * 将中间状态结果容器转换为最终的返回结果
     *
     * @return
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    /**
     * 采用哪些优化建议
     *
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        Set<Characteristics> set = new HashSet<>();
        set.add(Characteristics.IDENTITY_FINISH);
        set.add(Characteristics.CONCURRENT);
        return set;
    }
}
