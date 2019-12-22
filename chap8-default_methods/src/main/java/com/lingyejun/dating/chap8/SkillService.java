package com.lingyejun.dating.chap8;

/**
 * @Author: lingyejun
 * @Date: 2019/12/22
 * @Describe: 
 * @Modified By:
 */
public interface SkillService {

    void q();

    void w();

    void e();

    default void r(){
        System.out.println("默认大招：伤害100点");
    }
}
