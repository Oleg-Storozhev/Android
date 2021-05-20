package com.example.homework3.Entities;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.homework3.CompanyDao;

@Database(entities = {CompanyEntity.class},version=1)
public abstract class CompanyDB extends RoomDatabase {
    public static CompanyDB instance;
    public abstract CompanyDao companyDao();
}

