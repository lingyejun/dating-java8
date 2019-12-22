package com.lingyejun.dating.chap9;

import java.util.Optional;

/**
 * @Author: lingyejun
 * @Date: 2019/12/21
 * @Describe:
 * @Modified By:
 */
public class User {

    private String userName;

    private Car car;

    private Optional<House> house;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Optional<House> getHouse() {
        return house;
    }

    public void setHouse(Optional<House> house) {
        this.house = house;
    }
}
