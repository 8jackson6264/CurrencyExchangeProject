package com.example.currencyexchange.ui.fragments;

import com.example.currencyexchange.R;
import com.example.currencyexchange.databinding.TabExchangeRatesBinding;

import javax.inject.Inject;

public class ExchangeRatesTab extends BaseFragment<TabExchangeRatesBinding> {

    @Inject
    public ExchangeRatesTab() {

    }

    @Override
    public int getLayoutRes() {
        return R.layout.tab_exchange_rates;
    }
}
