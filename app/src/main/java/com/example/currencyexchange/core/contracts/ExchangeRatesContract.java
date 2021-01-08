package com.example.currencyexchange.core.contracts;

import android.content.Context;

public interface ExchangeRatesContract {
    interface ExchangeRatesTabPresenterListener {
        void getCoursesFromApi(Context context);
    }

    interface ExchangeRatesTabViewListener {
    }
}
