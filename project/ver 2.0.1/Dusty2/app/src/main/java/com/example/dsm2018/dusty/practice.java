package com.example.dsm2018.dusty;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface practice {
    @GET("/")
    Call<String> getResult (
            @Query("expr") String expr
    );
}
