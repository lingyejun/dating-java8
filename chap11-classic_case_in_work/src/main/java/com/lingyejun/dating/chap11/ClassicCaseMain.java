package com.lingyejun.dating.chap11;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: lingyejun
 * @Date: 2020/3/29
 * @Describe:
 * @Modified By:
 */
public class ClassicCaseMain {

    public static void main(String[] args) {

        // 从数据库中拿出商品价格列表
        List<SkuCountryPrice> skuCountryPriceList = querySkuCountryPriceFromDB();

        // spu -- sku, 1 -- n

        // sku -- price, 1 -- n

        // sku -- country, 1 -- n

        // sku + country -- price, 1 -- 1

        // 列出对象中的某一个属性，并且进行去重
        List<Integer> skuIdList = skuCountryPriceList.stream().map(SkuCountryPrice::getSkuId).distinct().collect(Collectors.toList());
        Set<Integer> spuIdSet = skuCountryPriceList.stream().map(SkuCountryPrice::getSpuId).collect(Collectors.toSet());


        // 按照列表中的某一个字段进行分组，得到一个 1 -- n Map关系对象
        Map<Integer, List<SkuCountryPrice>> map1 = skuCountryPriceList.stream().collect(Collectors.groupingBy(SkuCountryPrice::getSkuId));
        Map<Integer, List<BigDecimal>> map2 = skuCountryPriceList.stream().collect(Collectors.groupingBy(SkuCountryPrice::getSkuId, Collectors.mapping(SkuCountryPrice::getSkuPrice, Collectors.toList())));

        // 对列表中的数据先想办法进行过滤，然后再进行一次分组使 1 -- n的关系，转变为 1 -- 1 的关系
        String country = "China";
        Map<Integer, SkuCountryPrice> map3 = skuCountryPriceList.stream().filter(skuCountryPrice -> Objects.equals(skuCountryPrice.getCountry(), country)).collect(Collectors.toMap(SkuCountryPrice::getSkuId, Function.identity()));
        Map<Integer, BigDecimal> map4 = skuCountryPriceList.stream().filter(skuCountryPrice -> Objects.equals(skuCountryPrice.getCountry(), country)).collect(Collectors.toMap(SkuCountryPrice::getSkuId, SkuCountryPrice::getSkuPrice));

        // 对列表中的数据，进行两次分组操作，得到一个 1 -- n -- n
        // skuId -- country -- Object
        Map<Integer, Map<String, SkuCountryPrice>> map5 = skuCountryPriceList.stream().collect(Collectors.groupingBy(SkuCountryPrice::getSkuId, Collectors.toMap(SkuCountryPrice::getCountry, Function.identity())));
        Map<Integer, Map<String, BigDecimal>> map6 = skuCountryPriceList.stream().collect(Collectors.groupingBy(SkuCountryPrice::getSkuId, Collectors.toMap(SkuCountryPrice::getCountry, SkuCountryPrice::getSkuPrice)));

        // skuId + country --> Object/BigDecimal
        Integer skuId = 104;
        String skuCountry = "China";

        Map<String, SkuCountryPrice> result1 = map5.get(skuId);
        if (Objects.nonNull(result1)) {
            SkuCountryPrice skuCountryPrice = result1.get(skuCountry);
        }

        // 如何直接一步到位，根据skuId + country直接获取对象？
        // 骚操作，通过字段拼接，直接得到一个 1 -- 1的对象
        Map<String,SkuCountryPrice> map7 = skuCountryPriceList.stream().collect(Collectors.toMap(skuCountryPrice -> keysJoin(skuCountryPrice.getSkuId(),skuCountryPrice.getCountry()),Function.identity()));
        SkuCountryPrice result2 = map7.get(keysJoin(skuId,skuCountry));

        System.out.println("======");
    }

    /**
     * 将a和b连接起来，作为一个完整的Key
     *
     * @param a
     * @param b
     * @return
     */
    public static String keysJoin(Integer a, String b) {
        return a + "-" + b;
    }

    public static List<SkuCountryPrice> querySkuCountryPriceFromDB() {

        SkuCountryPrice skuCountryPrice1 = new SkuCountryPrice(1, 100, 1, "iPhone 11 Pro 64GB 深空灰色", "iPhone 11 Pro", "China", new BigDecimal(8699));
        SkuCountryPrice skuCountryPrice2 = new SkuCountryPrice(2, 101, 1, "iPhone 11 Pro 512GB 金色", "iPhone 11 Pro", "China", new BigDecimal(11799));
        SkuCountryPrice skuCountryPrice3 = new SkuCountryPrice(3, 102, 2, "iPhone XR 64GB 蓝色", "iPhone XR", "China", new BigDecimal(4799));
        SkuCountryPrice skuCountryPrice4 = new SkuCountryPrice(4, 103, 2, "iPhone XR 128GB 黄色", "iPhone XR", "China", new BigDecimal(5299));
        SkuCountryPrice skuCountryPrice5 = new SkuCountryPrice(5, 104, 2, "iPhone XR 128GB 珊瑚色", "iPhone XR", "China", new BigDecimal(5299));

        SkuCountryPrice skuCountryPrice6 = new SkuCountryPrice(6, 100, 1, "iPhone 11 Pro 64GB 深空灰色", "iPhone 11 Pro", "Japan", new BigDecimal(106800));
        SkuCountryPrice skuCountryPrice7 = new SkuCountryPrice(7, 101, 1, "iPhone 11 Pro 512GB 金色", "iPhone 11 Pro", "Japan", new BigDecimal(144800));
        SkuCountryPrice skuCountryPrice8 = new SkuCountryPrice(8, 102, 2, "iPhone XR 64GB 蓝色", "iPhone XR", "Japan", new BigDecimal(64800));
        SkuCountryPrice skuCountryPrice9 = new SkuCountryPrice(9, 103, 2, "iPhone XR 128GB 黄色", "iPhone XR", "Japan", new BigDecimal(69800));
        SkuCountryPrice skuCountryPrice10 = new SkuCountryPrice(10, 104, 2, "iPhone XR 128GB 珊瑚色", "iPhone XR", "Japan", new BigDecimal(69800));

        return Arrays.asList(skuCountryPrice1, skuCountryPrice2, skuCountryPrice3, skuCountryPrice4, skuCountryPrice5,
                skuCountryPrice6, skuCountryPrice7, skuCountryPrice8, skuCountryPrice9, skuCountryPrice10);
    }
}
