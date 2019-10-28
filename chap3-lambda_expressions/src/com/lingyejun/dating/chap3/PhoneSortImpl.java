package com.lingyejun.dating.chap3;

import com.lingyejun.dating.chap2.Phone;

import java.util.Comparator;

/**
 * @Author: lingyejun
 * @Date: 2019/10/28
 * @Describe:
 * @Modified By:
 */
public class PhoneSortImpl implements Comparator<Phone> {

    @Override
    public int compare(Phone o1, Phone o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
