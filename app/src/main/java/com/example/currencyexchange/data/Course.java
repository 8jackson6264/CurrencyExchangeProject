package com.example.currencyexchange.data;

public class Course {
    private String currencyName;
    private double course;


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
