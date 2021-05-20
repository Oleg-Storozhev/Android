package com.example.homework3;

import com.example.homework3.IBM.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OneWeekAct {
    @GET("/query")
    Call<Example> getcompanyinfo(@Query("function") String function, @Query("symbol") String company, @Query("apikey") String appID);

}
