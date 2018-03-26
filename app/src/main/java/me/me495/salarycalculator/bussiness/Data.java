package me.me495.salarycalculator.bussiness;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import me.me495.salarycalculator.entity.InsuranceRate;

/**
 * Created by ME495 on 2018/3/26.
 * 存储数据的类
 */

public class Data {
    private static HashMap<String, InsuranceRate> map;
    private static ArrayList<String> citys;
    public static ArrayList<String> getCitys() {
        return citys;
    }

    public static void init(Context context){
        map = new HashMap<>();
        citys = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(getJson("insurance.json", context));
            jsonObject = jsonObject.optJSONObject("insurance");
            Iterator<?> it = jsonObject.keys();
            while(it.hasNext()) {
                String key = it.next().toString();
                Log.e("key", key);
                citys.add(key);
                JSONObject object = jsonObject.optJSONObject(key);
                InsuranceRate insurance = new InsuranceRate();
                insurance.setYangLao0(object.optDouble("yangLao0"));insurance.setYangLao1(object.optDouble("yangLao1"));
                insurance.setYiLiao0(object.optDouble("yiLiao0"));insurance.setYiLiao1(object.optDouble("yiLiao1"));insurance.setAddition(object.optDouble("addition"));
                insurance.setShiYe0(object.optDouble("shiYe0"));insurance.setShiYe1(object.optDouble("shiYe1"));
                insurance.setGongShang0(object.optDouble("gongShang0"));insurance.setGongShang1(object.optDouble("gongShang1"));
                insurance.setShengYu0(object.optDouble("shengYu0"));insurance.setShengYu1(object.optDouble("shengYu1"));
                insurance.setZhuFang0(object.optDouble("zhuFang0"));insurance.setZhuFang1(object.optDouble("zhuFang1"));
                insurance.setSheBaoLower(object.optDouble("sheBaoLower"));insurance.setSheBaoUpper(object.optDouble("sheBaoUpper"));
                insurance.setJiJinLower(object.optDouble("jiJinLower"));insurance.setJiJinUpper(object.optDouble("jiJinUpper"));
                map.put(key, insurance);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        InsuranceRate beijing = new InsuranceRate();
//        beijing.setYangLao0(0.08);beijing.setYangLao1(0.21);
//        beijing.setYiLiao0(0.02);beijing.setYiLiao1(0.11);beijing.setAddition(0);
//        beijing.setShiYe0(0.005);beijing.setShiYe1(0.015);
//        beijing.setGongShang0(0);beijing.setGongShang1(0.005);
//        beijing.setShengYu0(0);beijing.setShengYu1(0.01);
//        beijing.setZhuFang0(0.07);beijing.setZhuFang1(0.07);
//        beijing.setSheBaoLower(3271.00);beijing.setSheBaoUpper(16353.00);
//        beijing.setJiJinLower(1814.29);beijing.setJiJinUpper(16357.14);
//        map.put("北京", beijing);
    }


    public static String getJson(String fileName,Context context) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static InsuranceRate getInsuranceRate(String city){
        return map.get(city);
    }
}
