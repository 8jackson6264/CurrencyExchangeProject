package com.example.currencyexchange.core.presenters;

import android.content.Context;

import com.example.currencyexchange.core.contracts.SavedCoursesContract;
import com.example.currencyexchange.data.Course;
import com.example.currencyexchange.data.db.CourseDBService;

import java.util.ArrayList;
import java.util.List;

public class SavedCoursesPresenter implements SavedCoursesContract.SavedCoursesTabPresenterListener {

    SavedCoursesContract.SavedCoursesTabViewListener viewListener;
    CourseDBService courseDBService;

    @Override
    public void setViewListener(SavedCoursesContract.SavedCoursesTabViewListener viewListener, Context context) {
        this.viewListener = viewListener;
        courseDBService = new CourseDBService(context);
    }

    @Override
    public void getCourseListFromDB() {
        courseDBService.getAllCourses(new CourseDBService.DataListener<List<Course>>() {
            @Override
            public void onData(List<Course> data) {
                viewListener.setCourseAdapterList(data);
            }
        });

    }
}
