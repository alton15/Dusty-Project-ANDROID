package com.example.dsm2018.dusty;

import retrofit2.Call;
import retrofit2.http.GET;

public interface receive {
    @GET("/")
    Call <DustyModel> getResult ();
}
