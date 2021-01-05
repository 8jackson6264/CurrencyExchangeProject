package com.example.currencyexchange.data.api;

import com.example.currencyexchange.data.ExchangeRate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Api instance;
    private final ApiService service;

    private Api() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" https://api.exchangeratesapi.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);
    }

    public static Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }
        return instance;
    }

    public void getAllExchangeRates(final ApiListener listener) {
        service.getAllExchangeRates().enqueue(new Callback<ExchangeRate>() {
            @Override
            public void onResponse(Call<ExchangeRate> call, Response<ExchangeRate> response) {
                if (response.isSuccessful()) {
                    listener.onExchangeRateReceived(response.body());
                } else {
                    listener.onFailure();
                }
            }

            @Override
            public void onFailure(Call<ExchangeRate> call, Throwable t) {
                listener.onFailure();
            }
        });
    }

    public interface ApiListener {

        void onFailure();

        void onExchangeRateReceived(ExchangeRate exchangeRate);
    }
}
