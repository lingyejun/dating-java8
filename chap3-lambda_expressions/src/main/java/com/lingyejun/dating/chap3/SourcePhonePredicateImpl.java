package com.lingyejun.dating.chap3;

import com.lingyejun.dating.chap2.Phone;
import com.lingyejun.dating.chap2.PhonePredicate;

/**
 * @Author: lingyejun
 * @Date: 2019/10/27
 * @Describe: 
 * @Modified By:
 */
public class SourcePhonePredicateImpl implements PhonePredicate {

    @Override
    public boolean test(Phone phone) {
        System.out.println("This is phone");
        return false;
    }
}
