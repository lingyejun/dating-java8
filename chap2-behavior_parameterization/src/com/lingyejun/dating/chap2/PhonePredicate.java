package com.lingyejun.dating.chap2;

/**
 * 判断手机是否满足某一个条件
 *
 * @Author: lingyejun
 * @Date: 2019/10/27
 * @Describe: 
 * @Modified By:
 */
@FunctionalInterface
public interface PhonePredicate {

    boolean test(Phone phone);
}
