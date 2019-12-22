package com.lingyejun.dating.chap8;

/**
 * @Author: lingyejun
 * @Date: 2019/12/22
 * @Describe:
 * @Modified By:
 */
public class Shooter implements SkillService,MoveService {
    @Override
    public void run() {
        System.out.println("寒冰射手 走~~");
    }

    @Override
    public void q() {
        System.out.println("寒冰 q");
    }

    @Override
    public void w() {
        System.out.println("寒冰 w");
    }

    @Override
    public void e() {
        System.out.println("寒冰 e");
    }

    public void r(){
        System.out.println("寒冰 伤害100点！！同时冰冻对方5s！！！");
    }

    public static void main(String[] args) {
        new Shooter().r();
    }
}
