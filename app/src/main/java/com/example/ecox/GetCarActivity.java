package com.example.ecox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class GetCarActivity extends AppCompatActivity {
    String[] city = {"bangalore" , "delhi", "Mumbai"};

    public static final String INT_Milage = "key_for_milage";
    public static final String mlgPref = "milage_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_car);

        //Background


        RelativeLayout constraintLayout = findViewById(R.id.loginconstraint);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        //



    }
    public void startAsyncTask(View view) {
        EditText carName = (EditText) findViewById(R.id.CarNameEditText);
        String car_name = carName.getText().toString();
        String carUrl = "https://www.carwale.com/marutisuzuki-cars/" + car_name;
        carsync task = new carsync();

               task.execute(carUrl);
       //Toast.makeText(this ,f,Toast.LENGTH_LONG).show();



    }

    private class carsync extends AsyncTask<String, Void, String[]> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected String[] doInBackground(String... s) {
            //String carUrl = "https://www.carwale.com/marutisuzuki-cars/swift";
            Document air = null;
            Document web = null;
            try {
                web = Jsoup.connect(s[0]).get();
                air = Jsoup.connect("https://aqicn.org/city/bangalore/").get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String mlg = web.getElementsByClass("right-data").get(1).text();
            String[] milageSP = mlg.split(" ");
            String Milage = milageSP[0];



            String ARQ = air.getElementsByClass("aqivalue").get(1).text();
            String[] webata = new String[2];
            webata[0] = Milage;
            webata[1] = ARQ;
            return webata;






        }



        @Override
        protected void onPostExecute(String mlg[]) {
            super.onPostExecute(mlg);

                      extracter(mlg[0],mlg[1]);



        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }


public String extracter (String x , String y)

{

    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
    SharedPreferences.Editor editor = pref.edit();
    editor.putString("value", x);
    editor.putString("air", y);
        editor.apply();

    Intent intent = new Intent(this, dashboard.class);
    //intent.putExtra(INT_Milage , x);

    startActivity(intent);


    return x;
}

}

