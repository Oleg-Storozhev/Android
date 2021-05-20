package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {
    Button btnIBM;
    Button btnTSCO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainAct1","ONCREATE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.alphavantage.co")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        MessageAPI messageAPI=retrofit.create(MessageAPI.class);
        Call<String> message=messageAPI.message();

        message.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Jane",""+response.body());
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("Jane","Failure"+t);
            }
        });

        btnIBM = findViewById(R.id.bt1);
        btnIBM.setOnClickListener(this :: OnbtnIBMClick);
        btnTSCO = findViewById(R.id.bt2);
        btnTSCO.setOnClickListener(this :: OnbtnTSCOClick);
    }

    public interface MessageAPI{
        @GET("http://www.alphavantage.co/query?function=EARNINGS&symbol=IBM&apikey=90DK4MWBW18N6V4S")
        Call<String> message();
    }
    public void OnbtnIBMClick(View v){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }
    public void OnbtnTSCOClick(View v){
        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(intent);
    }



/*
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainAct1","ONSTOP");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainAct1","ONRESUME");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainAct1","ONDESTROY");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainAct1","ONPAUSE");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainAct1","ONRESTART");
    }*/
}