package com.example.homework3;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.homework3.Entities.CompanyEntity;

import java.util.List;

import androidx.room.Query;

@Dao
public interface CompanyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCompany(CompanyEntity companyEntity);

    @Query("Select * FROM CompanyEntity where id = 0")
    public LiveData<CompanyEntity> getOneDayCompany();

    @Query("Select * FROM CompanyEntity where id != 0")
    public LiveData<List<CompanyEntity>> getOneWeekCompany();
}