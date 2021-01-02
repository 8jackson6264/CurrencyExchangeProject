package com.example.currencyexchange.ui.fragments;

import com.example.currencyexchange.R;

import javax.inject.Inject;

public class ExchangeRatesTab extends BaseFragment {

    @Inject
    public ExchangeRatesTab() {

    }

    @Override
    public int getLayoutRes() {
        return R.layout.tab_exchange_rates;
    }
}
