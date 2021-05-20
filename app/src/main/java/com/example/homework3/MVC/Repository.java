package com.example.homework3.MVC;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import com.example.homework3.MVC.LocalDataSource;
import com.example.homework3.IBM.Example;
import com.example.homework3.Entities.CompanyEntity;

import java.util.concurrent.Executors;

public class Repository {
    private LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;
    public Repository(Context context){
        localDataSource = new LocalDataSource(context);
        remoteDataSource = new RemoteDataSource();
    }

    public void ShowEPS(Example example){
        CompanyEntity ce =new CompanyEntity();
        CompanyEntity companyEntity=new CompanyEntity();
        companyEntity.id=0;
        companyEntity.fiscalDateEnding = example.getAnnualEarning().getFiscalDateEnding();
        companyEntity.reportedEPS = example.getAnnualEarning().getReportedEPS();
        localDataSource.storeCompany(companyEntity);
    }

    public LiveData<CompanyEntity> getEPSData(String s){// 1 день
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                Example EPS = remoteDataSource.getDay(s);
                Log.i("Jane",EPS.getAnnualEarning().getFiscalDateEnding());
                ShowEPS(EPS);
            }
        });
        return localDataSource.getInfo4NotNow();
    }
}