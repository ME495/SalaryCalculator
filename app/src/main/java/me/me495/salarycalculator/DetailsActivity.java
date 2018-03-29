package me.me495.salarycalculator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;
import me.me495.salarycalculator.bussiness.Data;
import me.me495.salarycalculator.bussiness.TaxUtil;
import me.me495.salarycalculator.entity.InsuranceRate;
import me.me495.salarycalculator.entity.InsuranceValue;


/**
 * 作者：李航
 * 时间：2018/3/26
 * 功能：显示五险一金和税后工资的详情
 */
public class DetailsActivity extends AppCompatActivity {
    //养老保险，0表示个人缴纳，1表示单位缴纳，total表示养老保险的总数
    private TextView yangLao0, yangLao1, yangLaoTotal;
    //事业保险
    private TextView shiYe0, shiYe1, shiYeTotal;
    //工伤保险
    private TextView gongShang0, gongShang1,gongShangTotal;
    //生育保险
    private TextView shengYu0, shengYu1,shengYuTotal;
    //医疗保险
    private TextView yiLiao0, yiLiao1,yiLiaoTotal;
    //住房公积金
    private TextView zhuFang0, zhuFang1,zhuFangTotal;

    //五险一金个人缴纳总数，个人所得税，税后工资，税前工资
    private TextView insuranceView, personalView, remainView, salaryView;

    //饼状图
    private PieChartView pie;

    //饼状图的数据
    private PieChartData pieChardata;
    ArrayList<SliceValue> sliceValues = new ArrayList<>();

    //五险一金的比例
    private InsuranceRate insuranceRate;

    //五险一金要缴纳的数量
    private InsuranceValue insuranceValue;

    //税前工资，个人所得税
    private double salary, personalIncomeTax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        Log.e("salary", intent.getStringExtra("salary"));
        salary = Double.valueOf(intent.getStringExtra("salary"));
        Log.e("city", intent.getStringExtra("city"));

        //获得所在城市的五险一金比例
        insuranceRate = Data.getInsuranceRate(city);
        //计算出五险一金所要缴纳的数量
        insuranceValue = TaxUtil.getInsuranceValue(insuranceRate, salary);

        //如果工资不够交五险一金，则返回主界面
        if (insuranceValue.getTotal0() > salary) {
            setResult(12);
            finish();
        }
        //计算个人所得税
        personalIncomeTax = TaxUtil.getPersonalIncomeTax(salary-insuranceValue.getTotal0());

        //构造饼状图的数据
        sliceValues.add(new SliceValue((float) insuranceValue.getTotal0(), getResources().getColor(R.color.colorInsurance)));
        sliceValues.add(new SliceValue((float) personalIncomeTax, getResources().getColor(R.color.colorPersonal)));
        sliceValues.add(new SliceValue((float)(salary-insuranceValue.getTotal0()-personalIncomeTax), getResources().getColor(R.color.colorRemain)));

        //显示数据
        showData();
    }

    //初始化，将元件与对象绑定
    private void init() {
        pie = findViewById(R.id.pie);
        insuranceView = findViewById(R.id.insurance);
        personalView = findViewById(R.id.personal);
        remainView = findViewById(R.id.remain);
        salaryView = findViewById(R.id.salary);

        yangLao0 = findViewById(R.id.yang_lao_0);
        yangLao1 = findViewById(R.id.yang_lao_1);
        yangLaoTotal = findViewById(R.id.yang_lao_total);

        yiLiao0 = findViewById(R.id.yi_liao_0);
        yiLiao1 = findViewById(R.id.yi_liao_1);
        yiLiaoTotal = findViewById(R.id.yi_liao_total);

        shiYe0 = findViewById(R.id.shi_ye_0);
        shiYe1 = findViewById(R.id.shi_ye_1);
        shiYeTotal = findViewById(R.id.shi_ye_total);

        gongShang0 = findViewById(R.id.gong_shang_0);
        gongShang1 = findViewById(R.id.gong_shang_1);
        gongShangTotal = findViewById(R.id.gong_shang_total);

        shengYu0 = findViewById(R.id.sheng_yu_0);
        shengYu1 = findViewById(R.id.sheng_yu_1);
        shengYuTotal = findViewById(R.id.sheng_yu_total);

        zhuFang0 = findViewById(R.id.zhu_fang_0);
        zhuFang1 = findViewById(R.id.zhu_fang_1);
        zhuFangTotal = findViewById(R.id.zhu_fang_total);
    }

    //显示数据
    private void showData() {
        initPieChart();
        insuranceView.setText(String.format("%.2f", insuranceValue.getTotal0()));
        personalView.setText(String.format("%.2f", personalIncomeTax));
        remainView.setText(String.format("%.2f", salary-insuranceValue.getTotal0()-personalIncomeTax));
        salaryView.setText(String.format("%.2f", salary));

        yangLao0.setText(String.format("%.2f", insuranceValue.getYangLao0()));
        yangLao1.setText(String.format("%.2f", insuranceValue.getYangLao1()));
        yangLaoTotal.setText(String.format("%.2f", insuranceValue.getYangLaoTotal()));

        yiLiao0.setText(String.format("%.2f", insuranceValue.getYiLiao0()));
        yiLiao1.setText(String.format("%.2f", insuranceValue.getYiLiao1()));
        yiLiaoTotal.setText(String.format("%.2f", insuranceValue.getYiLiaoTotal()));

        shiYe0.setText(String.format("%.2f", insuranceValue.getShiYe0()));
        shiYe1.setText(String.format("%.2f", insuranceValue.getShiYe1()));
        shiYeTotal.setText(String.format("%.2f", insuranceValue.getShiYeTotal()));

        gongShang0.setText(String.format("%.2f", insuranceValue.getGongShang0()));
        gongShang1.setText(String.format("%.2f", insuranceValue.getGongShang1()));
        gongShangTotal.setText(String.format("%.2f", insuranceValue.getGongShangTotal()));

        shengYu0.setText(String.format("%.2f", insuranceValue.getShengYu0()));
        shengYu1.setText(String.format("%.2f", insuranceValue.getShengYu1()));
        shengYuTotal.setText(String.format("%.2f", insuranceValue.getShengYuTotal()));

        zhuFang0.setText(String.format("%.2f", insuranceValue.getZhuFang0()));
        zhuFang1.setText(String.format("%.2f", insuranceValue.getZhuFang1()));
        zhuFangTotal.setText(String.format("%.2f", insuranceValue.getZhuFangTotal()));
        
    }
    
    //初始化饼状图
    private void initPieChart() {

        pieChardata = new PieChartData();
        pieChardata.setHasLabels(false);//显示标签
        pieChardata.setHasLabelsOnlyForSelected(true);//不用点击显示占的百分比
        pieChardata.setHasLabelsOutside(false);//占的百分比是否显示在饼图外面
        pieChardata.setHasCenterCircle(true);//是否是环形显示
        pieChardata.setValues(sliceValues);//填充数据
        pieChardata.setCenterCircleColor(Color.WHITE);//设置环形中间的颜色
        pieChardata.setCenterCircleScale(0f);//设置环形的大小级别
        pie.setPieChartData(pieChardata);
        pie.setValueSelectionEnabled(false);//选择饼图某一块变大
        pie.setAlpha(1f);//设置透明度
        pie.setCircleFillRatio(1f);//设置饼图大小

    }
}
