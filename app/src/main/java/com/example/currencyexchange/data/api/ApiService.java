package com.example.currencyexchange.data.api;

import com.example.currencyexchange.data.ExchangeRate;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("https://api.exchangeratesapi.io/latest?base=BGN")
    Call<ExchangeRate> getAllExchangeRates();
}
