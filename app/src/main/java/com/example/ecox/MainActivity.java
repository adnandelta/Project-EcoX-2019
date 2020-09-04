package com.example.ecox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText KM = (EditText) findViewById(R.id.KiloEditText);



        PieChartView pieChartView = findViewById(R.id.chart);
        pieChartView = findViewById(R.id.chart);

        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(15, Color.BLUE).setLabel("Monday"));
        pieData.add(new SliceValue(25, Color.GRAY).setLabel("Tuesday"));
        pieData.add(new SliceValue(10, Color.MAGENTA).setLabel("Thursday"));
        pieData.add(new SliceValue(60, Color.RED).setLabel("Today"));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Index").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);









    }


    public void Calculate(View view){


        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        String text= sharedPreferences.getString("value","");




        Intent intent = getIntent();
        //String text = intent.getStringExtra(GetCarActivity.INT_Milage);
        double d = new Double(text).doubleValue();
        EditText KM = (EditText) findViewById(R.id.KiloEditText);
        String KM_E = KM.getText().toString();
        double kms = new Double(KM_E).doubleValue();
        double mlgx = (kms/d)*2640;
        int value = (int)mlgx;
        String co2 = new Integer(value).toString();
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText(co2);
        TextView dis = (TextView) findViewById(R.id.dist);
        dis.setText(KM_E);

    }


    public void MapClick(View view){

        Intent intent = new Intent(this, MapsActivity.class);


        startActivity(intent);
    }





    }



