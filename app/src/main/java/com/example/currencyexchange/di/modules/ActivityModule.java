package com.example.currencyexchange.di.modules;

import com.example.currencyexchange.ui.activities.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
