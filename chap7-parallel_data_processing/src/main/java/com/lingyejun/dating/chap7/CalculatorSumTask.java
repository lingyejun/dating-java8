package com.lingyejun.dating.chap7;

import java.util.concurrent.RecursiveTask;

/**
 * 求和任务
 *
 * @Author: lingyejun
 * @Date: 2019/12/15
 * @Describe:
 * @Modified By:
 */
public class CalculatorSumTask extends RecursiveTask<Long> {

    // 开始的值
    private Long start;

    // 结束的值
    private Long end;

    // 阈值，即结束fork的条件
    private static final Long THRESHOLD = 10000L;

    public CalculatorSumTask(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    /**
     * 求 start - end 之间的所有数的和
     *
     * @return
     */
    @Override
    protected Long compute() {

        // 数的间隔
        long length = end - start;

        // 任务足够小或不可分
        if (length <= THRESHOLD) {
            long sum = 0L;
            // 顺序计算该任务
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            // 将任务分成两个子任务
            CalculatorSumTask leftTask = new CalculatorSumTask(start, middle);
            leftTask.fork();
            CalculatorSumTask rightTask = new CalculatorSumTask(middle + 1, end);
            rightTask.fork();

            // 合并每个子任务的结果
            return leftTask.join() + rightTask.join();
        }
    }
}
