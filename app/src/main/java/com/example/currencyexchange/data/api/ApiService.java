package com.example.currencyexchange.data.api;

import com.example.currencyexchange.data.ExchangeRate;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("latest?base=BGN")
    Call<ExchangeRate> getAllExchangeRatesFromBGN();

    @GET("latest?base=EUR")
    Call<ExchangeRate> getAllExchangeRatesFromEUR();
}
