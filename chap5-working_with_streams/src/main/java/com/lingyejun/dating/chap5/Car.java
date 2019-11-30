package com.lingyejun.dating.chap5;

/**
 * @Author: lingyejun
 * @Date: 2019/11/16
 * @Describe:
 * @Modified By:
 */
public class Car {

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
