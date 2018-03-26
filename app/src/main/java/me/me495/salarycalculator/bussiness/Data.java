package me.me495.salarycalculator.bussiness;

import java.util.HashMap;

import me.me495.salarycalculator.entity.InsuranceRate;

/**
 * Created by ME495 on 2018/3/26.
 * 存储数据的类
 */

public class Data {
    private static HashMap<String, InsuranceRate> map;
    public static void init(){
        map = new HashMap<>();
        InsuranceRate beijing = new InsuranceRate();
        beijing.setYangLao0(0.08);beijing.setYangLao1(0.21);
        beijing.setYiLiao0(0.02);beijing.setYiLiao1(0.11);beijing.setAddition(0);
        beijing.setShiYe0(0.005);beijing.setShiYe1(0.015);
        beijing.setGongShang0(0);beijing.setGongShang1(0.005);
        beijing.setShengYu0(0);beijing.setShengYu1(0.01);
        beijing.setZhuFang0(0.07);beijing.setZhuFang1(0.07);
        beijing.setSheBaoLower(3271.00);beijing.setSheBaoUpper(16353.00);
        beijing.setJiJinLower(1814.29);beijing.setJiJinUpper(16357.14);
        map.put("北京", beijing);
    }

    public static InsuranceRate getTaxRage(String city){
        return map.get(city);
    }
}
