package com.lingyejun.dating.chap8;

/**
 * @Author: lingyejun
 * @Date: 2019/12/22
 * @Describe:
 * @Modified By:
 */
public interface PlayerService {

    void start();

    void pre();

    void next();

    void pause();

    default void stop(){
        System.out.println("通用播放器--停止");
    }
}
