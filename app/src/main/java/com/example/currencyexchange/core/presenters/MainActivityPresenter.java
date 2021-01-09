package com.example.currencyexchange.core.presenters;

import com.example.currencyexchange.core.contracts.MainActivityContract;

public class MainActivityPresenter implements MainActivityContract.MainActivityPresenterListener {

    MainActivityContract.MainActivityViewListener viewListener;

    @Override
    public void setViewListener(MainActivityContract.MainActivityViewListener viewListener) {
        this.viewListener = viewListener;
    }

}
