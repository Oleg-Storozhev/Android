package com.example.homework3.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CompanyEntity {
    @PrimaryKey
    @ColumnInfo(name = "id")
    public int id;
    @ColumnInfo(name = "fiscalDateEnding")
    public String fiscalDateEnding;
    @ColumnInfo(name = "reportedEPS")
    public String reportedEPS;
}