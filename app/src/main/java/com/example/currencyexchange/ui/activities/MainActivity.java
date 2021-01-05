package com.example.currencyexchange.ui.activities;

import com.example.currencyexchange.R;
import com.example.currencyexchange.adapters.TabAdapter;
import com.example.currencyexchange.databinding.ActivityMainBinding;
import com.example.currencyexchange.ui.fragments.ExchangeRatesTab;
import com.example.currencyexchange.ui.fragments.SavedCoursesTab;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

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
        binding.viewpager.setAdapter(tabAdapter);
        binding.viewpager.setUserInputEnabled(false);

        TabLayoutMediator mediator = new TabLayoutMediator(binding.tabs, binding.viewpager,
                this::setTextToTabs);
        mediator.attach();
    }

    private void setTextToTabs(TabLayout.Tab tab, int position) {
        switch (position) {
            case 0:
                tab.setText("Exchange Rates");
                break;
            case 1:
                tab.setText("Saved Courses");
                break;
            default:
                throw new IllegalArgumentException("Unavailable tab");
        }
    }


}