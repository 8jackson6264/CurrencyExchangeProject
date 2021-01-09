package com.example.currencyexchange.core.contracts;

import android.content.Context;

import com.example.currencyexchange.data.Course;
import com.example.currencyexchange.ui.activities.MainActivity;

import java.util.List;

public interface MainActivityContract  {
    interface MainActivityPresenterListener {
        void setViewListener(MainActivityContract.MainActivityViewListener viewListener);

    }

    interface MainActivityViewListener {

    }
}
