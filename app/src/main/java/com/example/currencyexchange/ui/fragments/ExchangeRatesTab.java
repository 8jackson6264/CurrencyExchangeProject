package com.example.currencyexchange.ui.fragments;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyexchange.R;
import com.example.currencyexchange.core.contracts.ExchangeRatesContract;
import com.example.currencyexchange.core.presenters.ExchangeRatesPresenter;
import com.example.currencyexchange.data.Course;
import com.example.currencyexchange.databinding.TabExchangeRatesBinding;
import com.example.currencyexchange.ui.adapters.CourseAdapter;

import java.util.List;

import javax.inject.Inject;

public class ExchangeRatesTab extends BaseFragment<TabExchangeRatesBinding>
        implements ExchangeRatesContract.ExchangeRatesTabViewListener {

    CourseAdapter courseAdapter;
    @Inject
    ExchangeRatesContract.ExchangeRatesTabPresenterListener exchangeRatesTabPresenterListener;


    @Inject
    public ExchangeRatesTab() {
    }

    @Override
    public int getLayoutRes() {
        return R.layout.tab_exchange_rates;
    }

    @Override
    public void onFragmentCreated() {
        exchangeRatesTabPresenterListener.setViewListener(this);
        setRecyclerView();
    }

    @Override
    public void setOptionsMenu(Menu menu) {
        menu.getItem(1).setVisible(false);
    }

    private void setRecyclerView() {
        binding.exchangeRatesRecyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        courseAdapter = new CourseAdapter();
        binding.exchangeRatesRecyclerView.setAdapter(courseAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        exchangeRatesTabPresenterListener.getCoursesFromApi(getContext());

    }


    @Override
    public void setCourseAdapterListToBGN(List<Course> courses) {
        courseAdapter.setCourses(courses);
    }

    @Override
    public void setCourseAdapterListToEUR(List<Course> courses) {

    }
}
