package com.tahaprojects.apiui;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApi {
    @GET("forecast.json")
    Call<MyClass> getApi(
            @Query("key") String key,
            @Query("q") String q,
            @Query("days") int days,
            @Query("aqi") String aqi,
            @Query("alerts") String alerts
    );
}
