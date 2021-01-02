package com.example.currencyexchange.di.modules;

import com.example.currencyexchange.ui.fragments.ExchangeRatesTab;
import com.example.currencyexchange.ui.fragments.SavedCoursesTab;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract ExchangeRatesTab provideExchangeRatesTba();

    @ContributesAndroidInjector
    abstract SavedCoursesTab provideSavedCoursesTab();
}