package com.example.currencyexchange.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "courses")
public class Course {
    @ColumnInfo(name = "currency_name")
    private String currencyName;
    @ColumnInfo(name = "course")
    private double course;
    @ColumnInfo(name = "base")
    private String base;

    @PrimaryKey(autoGenerate = true)
    private int id;


    public Course(String currencyName, double course) {
        this.currencyName = currencyName;
        this.course = course;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

}
