package com.example.currencyexchange.data.db;

import android.os.AsyncTask;

import com.example.currencyexchange.data.Course;

import java.util.List;

public class CourseDBService {
    private final CourseDAO courseDAO;

    public CourseDBService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public void getAllCourses(DataListener<List<Course>> dataListener) {
        new AsyncTask<Void, Void, List<Course>>() {
            @Override
            protected List<Course> doInBackground(Void... voids) {
                return courseDAO.getAll();
            }

            @Override
            protected void onPostExecute(List<Course> courses) {
                dataListener.onData(courses);
            }
        }.execute();
    }

    public void addCourse(Course course) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                courseDAO.addCourse((course));
                return null;

            }
        }.execute();
    }

    public void deleteCourseByCourse(double course) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                courseDAO.deleteQuoteByCourse(course);
                return null;
            }
        }.execute();
    }

    public interface DataListener<T> {
        void onData(T data);
    }
    
}