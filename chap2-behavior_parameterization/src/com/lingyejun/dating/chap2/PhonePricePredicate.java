package com.lingyejun.dating.chap2;

/**
 * @Author: lingyejun
 * @Date: 2019/10/27
 * @Describe:
 * @Modified By:
 */
public class PhonePricePredicate implements PhonePredicate {

    @Override
    public boolean test(Phone phone) {
        return phone.getPrice() > 8000;
    }
}
