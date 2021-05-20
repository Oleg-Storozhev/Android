package com.example.homework3.MVC;

import android.util.Log;

import com.example.homework3.IBM.Example;
import com.example.homework3.OneWeekAct;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {
    private OneWeekAct EPSApi;
    public RemoteDataSource(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.alphavantage.co")//базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create())//конвертер
                .build();
        EPSApi = retrofit.create(OneWeekAct.class);
    }

    public Example getDay(String s){
        Call<Example> call = EPSApi.getcompanyinfo("EARNINGS",s,"3d822b9dce4e57f12b9b3400d480a358");
        try {
            Response<Example> response = call.execute();
            if(response.isSuccessful()){
                Log.d("RemoteData",String.valueOf(response.body().getAnnualEarning().getFiscalDateEnding()));
                return response.body();
            }
        }catch(IOException ioex){
            Log.e("Remote", "IOEX: " + ioex.toString());
        }
        return null;
    }
}