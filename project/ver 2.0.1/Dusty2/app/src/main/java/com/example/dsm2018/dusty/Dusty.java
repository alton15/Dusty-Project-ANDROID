package com.example.dsm2018.dusty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Dusty extends AppCompatActivity {
    long now = System.currentTimeMillis();
    Date date = new Date(now);
    SimpleDateFormat sdfNow = new SimpleDateFormat("YY:DD:HH");
    String formatDate = sdfNow.format(date);
    static final String URL = "http://192.168.137.95:5000";

    TextView dateNow, dust, humidity, temperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dusty);

        dateNow = findViewById(R.id.dateNow);
        dateNow.setText(formatDate);
        dust = findViewById(R.id.dust);
        humidity = findViewById(R.id.humidity);
        temperature = findViewById(R.id.temperature);
        this.receive();
    }

    //정보 받아옴
    public void receive() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .build();
        final receive receive1 = retrofit.create(receive.class);
        Call <DustyModel> call = receive1.getResult();
        call.enqueue(new Callback<DustyModel>() {
            @Override
            public void onResponse(Call<DustyModel> call, Response<DustyModel> response) {
                DustyModel result = response.body();
                dust.setText(String.valueOf(result.getDusty()));
                humidity.setText(String.valueOf(result.getHumidity()));
                temperature.setText(String.valueOf(result.getTemperature()));
            }

            @Override
            public void onFailure(Call<DustyModel> call, Throwable t) {

            }
        });
    }
}
