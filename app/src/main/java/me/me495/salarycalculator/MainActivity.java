package me.me495.salarycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import me.me495.salarycalculator.bussiness.Data;

import static me.me495.salarycalculator.R.array.city_list;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private TextView salsayView;
    private ArrayList<String> dataList;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Data.init();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.calc);
        salsayView = findViewById(R.id.salary_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, getResources().getStringArray(R.array.city_list));
        spinner.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = spinner.getSelectedItem().toString();
                String salary = salsayView.getText().toString();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DetailsActivity.class);
                intent.putExtra("city", city);
                intent.putExtra("salary", salary);
                startActivity(intent);
            }
        });
    }
}