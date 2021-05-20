package com.example.homework3.MVC;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.homework3.Entities.CompanyDB;
import com.example.homework3.Entities.CompanyEntity;

import java.util.List;

public class LocalDataSource {
    final CompanyDB db;

    public LocalDataSource(Context context){
        db = Room.databaseBuilder(context, CompanyDB.class,"EPS"). fallbackToDestructiveMigration().build();
    }
    public void storeCompany(CompanyEntity ce) {
        db.companyDao().insertCompany(ce);
    }
    public LiveData<List<CompanyEntity>> getInfo4now(){
        return db.companyDao().getOneWeekCompany();
    }

    public LiveData<CompanyEntity> getInfo4NotNow(){
        return db.companyDao().getOneDayCompany();

    }


}