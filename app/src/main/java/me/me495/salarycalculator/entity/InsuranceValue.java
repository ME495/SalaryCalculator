package me.me495.salarycalculator.entity;

/**
 * Created by ME495 on 2018/3/26.
 * 税额
 */

public class InsuranceValue {
    //养老保险，0表示个人缴纳，1表示单位缴纳，total表示养老保险的总数
    private double yangLao0, yangLao1, yangLaoTotal;
    //事业保险
    private double shiYe0, shiYe1, shiYeTotal;
    //工伤保险
    private double gongShang0, gongShang1,gongShangTotal;
    //生育保险
    private double shengYu0, shengYu1,shengYuTotal;
    //医疗保险
    private double yiLiao0, yiLiao1,yiLiaoTotal;
    //住房公积金
    private double zhuFang0, zhuFang1,zhuFangTotal;
    //total0表示个人缴纳总数，total1表示单位缴纳总数，total表示缴纳总数
    private double total0, total1, total;

    public double getYangLao0() {
        return yangLao0;
    }

    public void setYangLao0(double yangLao0) {
        this.yangLao0 = yangLao0;
    }

    public double getYangLao1() {
        return yangLao1;
    }

    public void setYangLao1(double yangLao1) {
        this.yangLao1 = yangLao1;
    }

    public double getYangLaoTotal() {
        return yangLaoTotal;
    }

    public void setYangLaoTotal(double yangLaoTotal) {
        this.yangLaoTotal = yangLaoTotal;
    }

    public double getShiYe0() {
        return shiYe0;
    }

    public void setShiYe0(double shiYe0) {
        this.shiYe0 = shiYe0;
    }

    public double getShiYe1() {
        return shiYe1;
    }

    public void setShiYe1(double shiYe1) {
        this.shiYe1 = shiYe1;
    }

    public double getShiYeTotal() {
        return shiYeTotal;
    }

    public void setShiYeTotal(double shiYeTotal) {
        this.shiYeTotal = shiYeTotal;
    }

    public double getGongShang0() {
        return gongShang0;
    }

    public void setGongShang0(double gongShang0) {
        this.gongShang0 = gongShang0;
    }

    public double getGongShang1() {
        return gongShang1;
    }

    public void setGongShang1(double gongShang1) {
        this.gongShang1 = gongShang1;
    }

    public double getGongShangTotal() {
        return gongShangTotal;
    }

    public void setGongShangTotal(double gongShangTotal) {
        this.gongShangTotal = gongShangTotal;
    }

    public double getShengYu0() {
        return shengYu0;
    }

    public void setShengYu0(double shengYu0) {
        this.shengYu0 = shengYu0;
    }

    public double getShengYu1() {
        return shengYu1;
    }

    public void setShengYu1(double shengYu1) {
        this.shengYu1 = shengYu1;
    }

    public double getShengYuTotal() {
        return shengYuTotal;
    }

    public void setShengYuTotal(double shengYuTotal) {
        this.shengYuTotal = shengYuTotal;
    }

    public double getYiLiao0() {
        return yiLiao0;
    }

    public void setYiLiao0(double yiLiao0) {
        this.yiLiao0 = yiLiao0;
    }

    public double getYiLiao1() {
        return yiLiao1;
    }

    public void setYiLiao1(double yiLiao1) {
        this.yiLiao1 = yiLiao1;
    }

    public double getYiLiaoTotal() {
        return yiLiaoTotal;
    }

    public void setYiLiaoTotal(double yiLiaoTotal) {
        this.yiLiaoTotal = yiLiaoTotal;
    }

    public double getZhuFang0() {
        return zhuFang0;
    }

    public void setZhuFang0(double zhuFang0) {
        this.zhuFang0 = zhuFang0;
    }

    public double getZhuFang1() {
        return zhuFang1;
    }

    public void setZhuFang1(double zhuFang1) {
        this.zhuFang1 = zhuFang1;
    }

    public double getZhuFangTotal() {
        return zhuFangTotal;
    }

    public void setZhuFangTotal(double zhuFangTotal) {
        this.zhuFangTotal = zhuFangTotal;
    }

    public double getTotal0() {
        return total0;
    }

    public void setTotal0(double total0) {
        this.total0 = total0;
    }

    public double getTotal1() {
        return total1;
    }

    public void setTotal1(double total1) {
        this.total1 = total1;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
