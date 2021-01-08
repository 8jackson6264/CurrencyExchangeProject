package com.example.currencyexchange.core.presenters;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.currencyexchange.R;
import com.example.currencyexchange.core.contracts.ExchangeRatesContract;
import com.example.currencyexchange.data.Course;
import com.example.currencyexchange.data.ExchangeRate;
import com.example.currencyexchange.data.Rates;
import com.example.currencyexchange.data.api.Api;
import com.example.currencyexchange.ui.adapters.CourseAdapter;
import com.example.currencyexchange.utils.CourseUtil;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRatesPresenter implements ExchangeRatesContract.ExchangeRatesTabPresenterListener {

    private List<Course> coursesToBGN = new ArrayList<>();
    private List<Course> coursesToEuro = new ArrayList<>();


    @Override
    public void getCoursesFromApi(Context context) {
        Api.getInstance().getAllExchangeRatesFromBGN(new Api.ApiListener() {
            @Override
            public void onExchangeRateReceived(ExchangeRate exchangeRate) {
                coursesToBGN = CourseUtil.recastFromRatesToCourseList(exchangeRate.getRates());
            }

            @Override
            public void onFailure() {
                Toast.makeText(context, "Some error with the servers occurred", Toast.LENGTH_LONG).show();
            }
        });

        Api.getInstance().getAllExchangeRatesFromEUR(new Api.ApiListener() {
            @Override
            public void onExchangeRateReceived(ExchangeRate exchangeRate) {
                coursesToEuro = CourseUtil.recastFromRatesToCourseList(exchangeRate.getRates());
            }

            @Override
            public void onFailure() {
                Toast.makeText(context, "Some error with the servers occurred", Toast.LENGTH_LONG).show();
            }
        });
    }


}

