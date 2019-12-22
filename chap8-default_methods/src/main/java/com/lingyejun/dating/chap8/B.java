package com.lingyejun.dating.chap8;

/**
 * @Author: lingyejun
 * @Date: 2019/12/22
 * @Describe:
 * @Modified By:
 */
public interface B extends A {

    default void x() {
        System.out.println("B Interface : x ()");
    }
}
