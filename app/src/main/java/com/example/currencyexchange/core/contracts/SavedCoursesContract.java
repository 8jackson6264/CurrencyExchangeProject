package com.example.currencyexchange.core.contracts;

import android.content.Context;

import com.example.currencyexchange.data.Course;

import java.util.List;

public interface SavedCoursesContract {

    interface SavedCoursesTabPresenterListener {
        void setViewListener(SavedCoursesTabViewListener viewListener, Context context);

        void getCourseListFromDB();
    }

    interface SavedCoursesTabViewListener {
        void setCourseAdapterList(List<Course> courses);
    }

}
