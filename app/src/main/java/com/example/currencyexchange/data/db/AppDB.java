package com.example.currencyexchange.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.currencyexchange.data.Course;

@Database(entities = {Course.class}, version = 2)
public abstract class AppDB extends RoomDatabase {
    public abstract CourseDAO courseDAO();
}
