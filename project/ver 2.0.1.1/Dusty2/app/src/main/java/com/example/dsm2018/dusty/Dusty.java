package com.example.dsm2018.dusty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dusty extends AppCompatActivity {
    private static final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("YY:DD:HH");
    private String formatDate = LocalDateTime.now().format(timeFormat);

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

        DustyReceiver retrofit = DustyReceiver.receiver();
        Call <DustyModel> call = retrofit.getResult();
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

    //정보 받아옴
    public void receive() {

    }
}
