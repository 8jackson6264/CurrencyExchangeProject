package com.example.currencyexchange.data.db;

public class CourseDBService {
    private final CourseDAO courseDAO;

    public CourseDBService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }
}
