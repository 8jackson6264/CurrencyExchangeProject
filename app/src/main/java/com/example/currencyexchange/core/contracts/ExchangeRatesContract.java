package com.example.currencyexchange.core.contracts;

import android.content.Context;

import com.example.currencyexchange.data.Course;

import java.util.List;

public interface ExchangeRatesContract {
    interface ExchangeRatesTabPresenterListener {
        void setViewListener(ExchangeRatesContract.ExchangeRatesTabViewListener viewListener);
        void getCoursesFromApi(Context context, String base);
    }

    interface ExchangeRatesTabViewListener {
        void setCourseAdapterList(List<Course> courses);
    }
}
