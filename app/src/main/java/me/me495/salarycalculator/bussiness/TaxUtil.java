package me.me495.salarycalculator.bussiness;

import me.me495.salarycalculator.entity.InsuranceRate;
import me.me495.salarycalculator.entity.InsuranceValue;

/**
 * Created by ME495 on 2018/3/26.
 * 税额计算工具
 */

public class TaxUtil {
    //根据工资和税率计算五险一金的金额
    public static InsuranceValue getTaxValue(InsuranceRate rate, double salary){
        InsuranceValue value = new InsuranceValue();
        double base = salary;
        if (base < rate.getSheBaoLower()) {
            base = rate.getSheBaoLower();
        }
        if (base > rate.getSheBaoUpper()) {
            base = rate.getSheBaoUpper();
        }
        value.setYangLao0(base * rate.getYangLao0());
        value.setYangLao1(base * rate.getYangLao1());
        value.setYangLaoTotal(value.getYangLao0() + value.getYangLao1());

        value.setYiLiao0(base * rate.getYiLiao0() + rate.getAddition());
        value.setYiLiao1(base * rate.getYiLiao1());
        value.setYiLiaoTotal(value.getYiLiao0() + value.getYiLiao1());

        value.setShiYe0(base * rate.getShiYe0());
        value.setShiYe1(base * rate.getShiYe1());
        value.setShiYeTotal(value.getShiYe0() + value.getShiYe1());

        value.setGongShang0(base * rate.getGongShang0());
        value.setGongShang1(base * rate.getGongShang1());
        value.setGongShangTotal(value.getGongShang0() + value.getGongShang1());

        value.setShengYu0(base * rate.getShengYu0());
        value.setShengYu1(base * rate.getShengYu1());
        value.setShengYuTotal(value.getShengYu0() + value.getShengYu1());

        base = salary;
        if (base < rate.getJiJinLower()) {
            base = rate.getJiJinLower();
        }
        if (base > rate.getJiJinUpper()) {
            base = rate.getJiJinUpper();
        }
        value.setZhuFang0(base * rate.getZhuFang0());
        value.setZhuFang1(base * rate.getZhuFang1());
        value.setZhuFangTotal(value.getZhuFang0() + value.getZhuFang1());
        
        value.setTotal0(value.getYangLao0() + value.getYiLiao0() + value.getShiYe0() + value.getGongShang0() + value.getShengYu0() + value.getZhuFang0());
        value.setTotal1(value.getYangLao1() + value.getYiLiao1() + value.getShiYe1() + value.getGongShang1() + value.getShengYu1() + value.getZhuFang1());
        value.setTotal(value.getTotal0() + value.getTotal1());
        return value;
    }

    public static double getPersonalIncomeTax(double value) {
        if (value <= 3500) return 0;
        value -= 3500;
        if (value <= 1500) {
            return value * 0.03;
        } else if (value <= 4500) {
            return value * 0.1 - 105;
        } else if (value <= 9000) {
            return value * 0.2 - 555;
        } else if (value <= 35000) {
            return value * 0.25 - 1005;
        } else if (value <= 55000) {
            return value * 0.3 - 2755;
        } else if (value <= 80000) {
            return value * 0.35 - 5505;
        } else {
            return value * 0.45 - 13505;
        }
    }
}
