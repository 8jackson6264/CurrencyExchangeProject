package com.example.currencyexchange.ui.fragments;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;
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
    private String base = "BGN";


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
        setSearchListener();
    }

    @Override
    public void setOptionsMenu(Menu menu) {
        menu.getItem(2).setVisible(false);
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if(base.equals("BGN")){
            menu.getItem(1).setVisible(false);
        } else if (base.equals("EUR")){
            menu.getItem(0).setVisible(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.bgn) {
            this.base = "BGN";
            exchangeRatesTabPresenterListener.getCoursesFromApi(getContext(), base);
            requireActivity().invalidateOptionsMenu();
        } else if (item.getItemId() == R.id.eur) {
            this.base = "EUR";
            exchangeRatesTabPresenterListener.getCoursesFromApi(getContext(), base);
            requireActivity().invalidateOptionsMenu();
        }
        return super.onOptionsItemSelected(item);
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
        exchangeRatesTabPresenterListener.getCoursesFromApi(getContext(), base);

    }


    @Override
    public void setCourseAdapterList(List<Course> courses) {
        courseAdapter.setCourses(courses);
    }


    private void setSearchListener() {
        binding.searchField.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                courseAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                courseAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
