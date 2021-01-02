package com.example.currencyexchange.ui.activities;

import android.os.Bundle;

import com.example.currencyexchange.R;
import com.example.currencyexchange.adapters.TabAdapter;
import com.example.currencyexchange.data.api.ExchangeRatesService;
import com.example.currencyexchange.ui.fragments.ExchangeRatesTab;
import com.example.currencyexchange.ui.fragments.SavedCoursesTab;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    ExchangeRatesTab exchangeRatesTab;
    @Inject
    SavedCoursesTab savedCoursesTab;


    @Override
    protected void onActivityCreated() {
        managingTabs();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    private void managingTabs() {
        TabAdapter tabAdapter = new TabAdapter(this.getSupportFragmentManager(), getLifecycle(),
                exchangeRatesTab, savedCoursesTab);
        ViewPager2 viewPager2 = findViewById(R.id.viewpager);
        viewPager2.setAdapter(tabAdapter);
        viewPager2.setUserInputEnabled(false);
        TabLayout tabLayout = findViewById(R.id.tabs);
        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager2,
                this::setTextToTheTabLayoutDependingOnThePosition);
        mediator.attach();
    }

    private void setTextToTheTabLayoutDependingOnThePosition(TabLayout.Tab tab, int position) {
        switch (position) {
            case 0:
                tab.setText("Exchange Rates");
                break;
            case 1:
                tab.setText("Saved Courses");
                break;
            default:
                throw new IllegalArgumentException("unavailable tab");
        }
    }


}