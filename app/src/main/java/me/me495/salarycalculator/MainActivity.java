package me.me495.salarycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import me.me495.salarycalculator.bussiness.Data;
import me.me495.salarycalculator.bussiness.TaxUtil;
import me.me495.salarycalculator.entity.InsuranceRate;

import static me.me495.salarycalculator.R.array.city_list;

/**
 * 作者：李航
 * 时间：2018/3/26
 * 功能：app的主界面
 */
public class MainActivity extends AppCompatActivity {
    //下拉框
    private Spinner spinner;
    //社保基数，公积金基数
    private TextView sheBaoBase, jiJinBase;
    //工资
    private EditText salaryEdit;
    //提交按钮
    private Button button;
    //工资比例
    private InsuranceRate insuranceRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Data.init(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sheBaoBase = findViewById(R.id.shebao_base_view);
        jiJinBase = findViewById(R.id.jijin_base_view);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.calc);
        salaryEdit = findViewById(R.id.salary_view);

        //设置下拉框
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, Data.getCitys());
        spinner.setAdapter(adapter);

        //设置按钮监听器，按下按钮跳转到DetailsActivity,并发送城市和工资
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = spinner.getSelectedItem().toString();
                String salary = getSalary();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DetailsActivity.class);
                intent.putExtra("city", city);
                intent.putExtra("salary", salary);
                startActivity(intent);
            }
        });

        //设置下拉框监听器，选择一个城市后改变社保基数和公积金基数
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setBases();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //设置salaryEdit监听器，工资改变后改变社保基数和公积金基数
        salaryEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setBases();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        setBases();
    }

    //从salaryEdit中获取工资
    private String getSalary() {
        if(salaryEdit.getText()==null || salaryEdit.getText().toString().trim().equals("")) {
            return "0";
        } else {
            return salaryEdit.getText().toString();
        }
    }

    //根据工资和城市设置保险基数和公积金基数
    private void setBases() {
        double salary = Double.valueOf(getSalary());
        String city = spinner.getSelectedItem().toString();
        insuranceRate = Data.getInsuranceRate(city);

        if (salary <= insuranceRate.getSheBaoLower()) {
            sheBaoBase.setText(String.format("%.2f", insuranceRate.getSheBaoLower()));
        } else if (salary <= insuranceRate.getSheBaoUpper()) {
            sheBaoBase.setText(String .format("%.2f", salary));
        } else {
            sheBaoBase.setText(String.format("%.2f", insuranceRate.getSheBaoUpper()));
        }
        if (salary <= insuranceRate.getJiJinLower()) {
            jiJinBase.setText(String.format("%.2f", insuranceRate.getJiJinLower()));
        } else if (salary <= insuranceRate.getJiJinUpper()) {
            jiJinBase.setText(String .format("%.2f", salary));
        } else {
            jiJinBase.setText(String.format("%.2f", insuranceRate.getJiJinUpper()));
        }
    }
}