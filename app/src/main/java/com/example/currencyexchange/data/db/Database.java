package com.example.currencyexchange.data.db;

import android.content.Context;

import androidx.room.Room;

public class Database {
    private static AppDB instance;
    public static final String DATABASE_NAME = "com.example.myapplication.data.database";

    private Database() {
    }

    public static AppDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDB.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
