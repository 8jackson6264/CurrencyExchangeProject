package com.example.currencyexchange.data;

import com.google.gson.annotations.SerializedName;

public class ExchangeRate {

    @SerializedName(value = "base")
    private String baseCurrency;
    @SerializedName(value = "date")
    private String date;
    @SerializedName(value = "rates")
    private Rates rates;

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getDate() {
        return date;
    }

    public Rates getRates() {
        return rates;
    }
}
