package com.lingyejun.dating.chap5;

import java.util.List;

/**
 * @Author: lingyejun
 * @Date: 2019/11/16
 * @Describe:
 * @Modified By:
 */
public class Worker {

    private String name;

    private String sex;

    private Boolean isMarried;

    private Integer salary;

    private List<Car> carList;

    private List<House> houseList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Boolean getMarried() {
        return isMarried;
    }

    public void setMarried(Boolean married) {
        isMarried = married;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<House> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<House> houseList) {
        this.houseList = houseList;
    }

    public Worker(String name, String sex, Boolean isMarried, Integer salary, List<Car> carList, List<House> houseList) {
        this.name = name;
        this.sex = sex;
        this.isMarried = isMarried;
        this.salary = salary;
        this.carList = carList;
        this.houseList = houseList;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", isMarried=" + isMarried +
                ", salary=" + salary +
                ", carList=" + carList +
                ", houseList=" + houseList +
                '}';
    }
}
