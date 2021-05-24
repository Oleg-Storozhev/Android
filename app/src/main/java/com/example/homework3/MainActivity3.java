package com.example.homework3;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework3.Entities.CompanyEntity;
import com.example.homework3.MVC.Repository;

public class MainActivity3 extends AppCompatActivity {
    private Repository repository;
    LiveData<CompanyEntity> companyData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView recyclerView;
        recyclerView=findViewById(R.id.RV_2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        EditText fiscalDateEnding = findViewById(R.id.fiscalDateEnding);
        EditText reportedEPS = findViewById(R.id.reportedEPS);

        repository=new Repository(this);
        companyData=repository.getEPSData("BAC");
        companyData.observe(this, new Observer<CompanyEntity>() {
            @Override
            public void onChanged(CompanyEntity companyEntity) {
                if (companyData!=null) {
                    Log.i("OLEG temp", String.valueOf(companyData.getValue().fiscalDateEnding));
                    fiscalDateEnding.setText(String.valueOf(companyData.getValue().fiscalDateEnding));
                    reportedEPS.setText(String.valueOf(companyData.getValue().reportedEPS));
                }
            }
        });

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            BlankFragment blankFragment=BlankFragment.newInstance("Bank of America Corporation", "1992 - 2020", ContextCompat.getColor(this, R.color.blue));
            getSupportFragmentManager().beginTransaction().add(R.id.fr_container3,blankFragment).commit();
        }

/*        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.alphavantage.co")//базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create())//конвертер
                .build();
        OneWeekAct oneWeekAct = retrofit.create(OneWeekAct.class);
        oneWeekAct.getcompanyinfo("EARNINGS","BAC","90DK4MWBW18N6V4S").
                enqueue(new Callback<Example>(){

                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        MyRecyclerViewAdapter adapter;
                        adapter = new MyRecyclerViewAdapter(getApplicationContext(), response.body().getAnnualEarnings());
                        recyclerView.setAdapter(adapter);

                        if (response.isSuccessful()) {
                            Executors.newSingleThreadExecutor().execute(new Runnable() {
                                @Override
                                public void run() {//кладём данные в БД
                                    for(int i=0;i<5;i++) {
                                        CompanyEntity companyEntity=new CompanyEntity();
                                        companyEntity.id=i;// почему так?
                                        companyEntity.fiscalDateEnding = response.body().getAnnualEarnings().get(i).getFiscalDateEnding();
                                        companyEntity.reportedEPS = response.body().getAnnualEarnings().get(i).getReportedEPS();
                                        Log.i("Jane FiscalDateEnding", ""+(response.body().getAnnualEarnings().get(i).getFiscalDateEnding()));
                                        Log.i("Jane ReportedEPS", ""+(response.body().getAnnualEarnings().get(i).getReportedEPS()));
                                    }
                                }

                            });


                        } else Log.i("Jane", "no reponse");
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Log.i("Jane","Failure"+t);
                    }
                });*/
    }
}