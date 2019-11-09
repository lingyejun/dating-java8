package com.lingyejun.dating.chap2;

/**
 * @Author: lingyejun
 * @Date: 2019/10/27
 * @Describe:
 * @Modified By:
 */
public class Phone {

    private Integer id;

    private String productName;

    private String color;

    private String spec;

    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Phone(Integer id, String productName, String color, String spec, Integer price) {
        this.id = id;
        this.productName = productName;
        this.color = color;
        this.spec = spec;
        this.price = price;
    }

    public Phone() {
    }

    public Phone(Integer price) {
        this.price = price;
    }
}
