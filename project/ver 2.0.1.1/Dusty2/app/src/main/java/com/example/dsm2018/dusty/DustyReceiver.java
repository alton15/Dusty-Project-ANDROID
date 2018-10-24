package com.example.dsm2018.dusty;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface DustyReceiver {
    public static final String URL = "http://54.180.88.48:5000";

    @GET("/api")
    Call <DustyModel> getResult ();

    public static DustyReceiver receiver() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build().create(DustyReceiver.class);
    }
}
