package com.lingyejun.dating.chap8;

/**
 * @Author: lingyejun
 * @Date: 2019/12/22
 * @Describe:
 * @Modified By:
 */
public interface MoveService {

    void run();

    default void flash() {
        System.out.println("闪现！！！");
    }
}
