package com.lingyejun.dating.chap8;

/**
 * @Author: lingyejun
 * @Date: 2019/12/22
 * @Describe: 
 * @Modified By:
 */
public class SonyPlayerServiceImpl implements PlayerService {
    
    @Override
    public void start() {
        System.out.println("Sony start");
    }

    @Override
    public void pre() {
        System.out.println("Sony do pre");
    }

    @Override
    public void next() {
        System.out.println("Sony do next");
    }

    @Override
    public void pause() {
        System.out.println("Sony do pause");
    }

    public static void main(String[] args) {
        new SonyPlayerServiceImpl().stop();
    }
}
