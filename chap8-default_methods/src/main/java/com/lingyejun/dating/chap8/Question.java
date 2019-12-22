package com.lingyejun.dating.chap8;

/**
 * @Author: lingyejun
 * @Date: 2019/12/22
 * @Describe:
 * @Modified By:
 */
public class Question implements PlayerService, RecordService {
    @Override
    public void start() {

    }

    @Override
    public void pre() {

    }

    @Override
    public void next() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {
        System.out.println("Question impl by self");
        PlayerService.super.stop();
    }

    public static void main(String[] args) {
        new Question().stop();
    }
}
