package com.example.currencyexchange.core.presenters;

import com.example.currencyexchange.core.contracts.ExchangeRatesContract;
import com.example.currencyexchange.data.Course;
import com.example.currencyexchange.data.Rates;
import com.example.currencyexchange.ui.adapters.CourseAdapter;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRatesPresenter implements ExchangeRatesContract.ExchangeRatesTabPresenterListener {
    private List<Course> recastFromRatesToCourseList(Rates rates){
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CAD", rates.getCanadianDollar()));
        courses.add(new Course("HKD", rates.getHongKongDollar()));
        courses.add(new Course("ISK", rates.getIcelandicKrona()));
        courses.add(new Course("PHP", rates.getPhilippinePeso()));
        courses.add(new Course("DKK", rates.getDanishKrone()));
        courses.add(new Course("HUF", rates.getHungarianForint()));
        courses.add(new Course("CZK", rates.getCzechKoruna()));
        courses.add(new Course("GBP", rates.getGreatBritainPound()));
        courses.add(new Course("RON", rates.getRomanianLeu()));
        courses.add(new Course("SEK", rates.getSwedishKrona()));
        courses.add(new Course("IDR", rates.getIndonesianRupiah()));
        courses.add(new Course("INR", rates.getIndianRupee()));
        courses.add(new Course("BRL", rates.getBrazilianReal()));
        courses.add(new Course("RUB", rates.getRussianRuble()));
        courses.add(new Course("EUR", rates.getEuro()));
        courses.add(new Course("MYR", rates.getMalaysianRinggit()));
        courses.add(new Course("TRY", rates.getTurkishLira()));
        courses.add(new Course("CNY", rates.getChineseYuan()));
        courses.add(new Course("NOK", rates.getNorwegianKrone()));
        courses.add(new Course("NZD", rates.getNewZealandDollar()));
        courses.add(new Course("ZAR", rates.getSouthAfricanRand()));
        courses.add(new Course("USD", rates.getUnitedStatesDollar()));
        courses.add(new Course("MXN", rates.getMexicanPeso()));
        courses.add(new Course("SGD", rates.getSingaporeDollar()));
        courses.add(new Course("AUD", rates.getAustralianDollar()));
        courses.add(new Course("ILS", rates.getIsraeliNewShekel()));
        courses.add(new Course("KRW", rates.getSouthKoreanWon()));
        courses.add(new Course("PLN", rates.getPolishZloty()));

        return courses;
    }

    CourseAdapter courseAdapter = new CourseAdapter();

//    void attachAdapter(){
//        courseAdapter.setCourses(recastFromRatesToCourseList());
    }

