package com.example.currencyexchange.data.db;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

public interface CourseDAO {

    @Insert
    void addCourse();
    @Query("SELECT * FROM courses")
    void getAll();
    @Query("DELETE FROM courses WHERE course = :course")
    void deleteQuoteBy(double course);
}
