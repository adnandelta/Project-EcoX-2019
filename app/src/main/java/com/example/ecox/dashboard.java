package com.example.ecox;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);



        PieChartView pieChartView = findViewById(R.id.chart);
        pieChartView = findViewById(R.id.chart);

        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(75, Color.BLUE).setLabel("Co2"));

        pieData.add(new SliceValue(25, Color.RED).setLabel("Other"));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(12);
        pieChartData.setHasCenterCircle(true).setCenterText1("Score-70").setCenterText1FontSize(18).setCenterText1Color(Color.parseColor("#999999"));
        pieChartView.setPieChartData(pieChartData);



        //air thingy

        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        String text_air = sharedPreferences.getString("air","");
        Intent intent = getIntent();
        TextView textView1 = (TextView) findViewById(R.id.air_textview);
        textView1.setText(text_air);








        //air end




        CardView co2card = (CardView) findViewById(R.id.bankcardId);
        co2card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inten;
                inten = new Intent(dashboard.this, MainActivity.class);
                startActivity(inten);

            }

        });


        CardView result = (CardView) findViewById(R.id.bankcardId1);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showCustomDialog();

            }

        });

        CardView dream = (CardView) findViewById(R.id.bankcardId3);
        dream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialogdream();

            }

        });
    }

        private void showCustomDialog(){




            //before inflating the custom alert dialog layout, we will get the current activity viewgroup
            ViewGroup viewGroup = findViewById(android.R.id.content);

            //then we will inflate the custom alert dialog xml that we created
            View dialogView = LayoutInflater.from(this).inflate(R.layout.dreamproj, viewGroup, false);


            //Now we need an AlertDialog.Builder object
            AlertDialog.Builder builder = new AlertDialog.Builder(dashboard.this);

            //setting the view of the builder to our custom view that we already inflated
            builder.setView(dialogView);

            //finally creating the alert dialog and displaying it
            AlertDialog alertDialog = builder.create();
            alertDialog.show();


        }

    private void showCustomDialogdream(){




        //before inflating the custom alert dialog layout, we will get the current activity viewgroup
        ViewGroup viewGroup = findViewById(android.R.id.content);

        //then we will inflate the custom alert dialog xml that we created
        View dialogView = LayoutInflater.from(this).inflate(R.layout.custompopup, viewGroup, false);


        //Now we need an AlertDialog.Builder object
        AlertDialog.Builder builders = new AlertDialog.Builder(dashboard.this);

        //setting the view of the builder to our custom view that we already inflated
        builders.setView(dialogView);

        //finally creating the alert dialog and displaying it
        AlertDialog alertDialogs = builders.create();
        alertDialogs.show();


    }
 
    }


