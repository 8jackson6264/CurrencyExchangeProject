package com.example.currencyexchange.di.modules;

import com.example.currencyexchange.core.contracts.ExchangeRatesContract;
import com.example.currencyexchange.core.contracts.SavedCoursesContract;
import com.example.currencyexchange.core.presenters.ExchangeRatesPresenter;
import com.example.currencyexchange.core.presenters.SavedCoursesPresenter;
import com.example.currencyexchange.data.ExchangeRate;
import com.example.currencyexchange.ui.fragments.SavedCoursesTab;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContractsModule {
    @Singleton
    @Provides
    public ExchangeRatesContract.ExchangeRatesTabPresenterListener providesQuizFragmentPresenter(){
        return new ExchangeRatesPresenter();
    }

    @Singleton
    @Provides
    public SavedCoursesContract.SavedCoursesTabPresenterListener providesScoreboardFragmentPresenter(){
        return new SavedCoursesPresenter();
    }
}
