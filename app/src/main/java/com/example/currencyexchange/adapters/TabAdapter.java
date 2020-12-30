package com.example.currencyexchange.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.currencyexchange.ui.fragments.ExchangeRatesTab;
import com.example.currencyexchange.ui.fragments.SavedCoursesTab;

import javax.inject.Inject;

public class TabAdapter extends FragmentStateAdapter {

    ExchangeRatesTab exchangeRatesTab;
    SavedCoursesTab savedCoursesTab;

    @Inject
    public TabAdapter(FragmentManager fragmentManager,
                      Lifecycle lifecycle,
                      ExchangeRatesTab exchangeRatesTab,
                      SavedCoursesTab savedCoursesTab) {
        super(fragmentManager, lifecycle);
        this.exchangeRatesTab = exchangeRatesTab;
        this.savedCoursesTab = savedCoursesTab;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return exchangeRatesTab;
            case 1:
                return savedCoursesTab;
            default:
                throw new IllegalArgumentException("Unavailable tab");
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
