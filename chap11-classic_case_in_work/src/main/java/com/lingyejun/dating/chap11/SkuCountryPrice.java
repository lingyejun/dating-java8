package com.lingyejun.dating.chap11;

import java.math.BigDecimal;

/**
 * @Author: lingyejun
 * @Date: 2020/3/29
 * @Describe:
 * @Modified By:
 */
public class SkuCountryPrice {

    private Integer id;

    private Integer skuId;

    private Integer spuId;

    private String skuName;

    private String spuName;

    private String country;

    private BigDecimal skuPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public SkuCountryPrice(Integer id, Integer skuId, Integer spuId, String skuName, String spuName, String country, BigDecimal skuPrice) {
        this.id = id;
        this.skuId = skuId;
        this.spuId = spuId;
        this.skuName = skuName;
        this.spuName = spuName;
        this.country = country;
        this.skuPrice = skuPrice;
    }

    @Override
    public String toString() {
        return "SkuCountryPrice{" +
                "id=" + id +
                ", skuId=" + skuId +
                ", spuId=" + spuId +
                ", skuName='" + skuName + '\'' +
                ", spuName='" + spuName + '\'' +
                ", country='" + country + '\'' +
                ", skuPrice=" + skuPrice +
                '}';
    }
}
