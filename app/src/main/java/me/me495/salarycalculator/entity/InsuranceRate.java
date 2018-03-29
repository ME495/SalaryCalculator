package me.me495.salarycalculator.entity;

/**
 * Created by ME495 on 2018/3/25.
 * 作者：程坚
 * 时间：2018/3/27
 * 功能：实体类，表示一个城市的税率
 */

public class InsuranceRate {
    //养老保险，0表示个人缴纳，1表示单位缴纳
    private double yangLao0, yangLao1;
    //医疗保险个人缴纳的附加值，在北京医疗保险的个人缴纳部分要附加3元
    private double addition;
    //事业保险
    private double shiYe0, shiYe1;
    //工伤保险
    private double gongShang0, gongShang1;
    //生育保险
    private double shengYu0, shengYu1;
    //医疗保险
    private double yiLiao0, yiLiao1;
    //住房公积金
    private double zhuFang0, zhuFang1;
    //社保基数下限和上限
    private double sheBaoLower, sheBaoUpper;
    //公积金基数下限和上限
    private double jiJinLower, jiJinUpper;

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

    public double getAddition() {
        return addition;
    }

    public void setAddition(double addition) {
        this.addition = addition;
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

    public double getSheBaoLower() {
        return sheBaoLower;
    }

    public void setSheBaoLower(double sheBaoLower) {
        this.sheBaoLower = sheBaoLower;
    }

    public double getSheBaoUpper() {
        return sheBaoUpper;
    }

    public void setSheBaoUpper(double sheBaoUpper) {
        this.sheBaoUpper = sheBaoUpper;
    }

    public double getJiJinLower() {
        return jiJinLower;
    }

    public void setJiJinLower(double jiJinLower) {
        this.jiJinLower = jiJinLower;
    }

    public double getJiJinUpper() {
        return jiJinUpper;
    }

    public void setJiJinUpper(double jiJinUpper) {
        this.jiJinUpper = jiJinUpper;
    }
}
