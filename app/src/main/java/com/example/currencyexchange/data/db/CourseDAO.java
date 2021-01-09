package com.example.currencyexchange.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.currencyexchange.data.Course;

import java.util.List;
@Dao
public interface CourseDAO {

    @Insert
    void addCourse(Course course);
    @Query("SELECT * FROM courses")
    List<Course> getAll();
    @Query("DELETE FROM courses WHERE course = :course")
    void deleteQuoteByCourse(double course);
}
