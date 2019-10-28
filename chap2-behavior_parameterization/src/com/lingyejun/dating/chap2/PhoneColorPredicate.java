package com.lingyejun.dating.chap2;

/**
 * @Author: lingyejun
 * @Date: 2019/10/27
 * @Describe:
 * @Modified By:
 */
public class PhoneColorPredicate implements PhonePredicate {

    @Override
    public boolean test(Phone phone) {
        return "深空灰色".equals(phone.getColor());
    }
}
