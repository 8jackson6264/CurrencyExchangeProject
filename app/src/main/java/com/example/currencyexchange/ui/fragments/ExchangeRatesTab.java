package com.example.currencyexchange.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.currencyexchange.R;
import com.example.currencyexchange.core.contracts.ExchangeRatesContract;
import com.example.currencyexchange.data.Course;
import com.example.currencyexchange.databinding.TabExchangeRatesBinding;
import com.example.currencyexchange.ui.adapters.CourseAdapter;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

public class ExchangeRatesTab extends BaseFragment<TabExchangeRatesBinding>
        implements ExchangeRatesContract.ExchangeRatesTabViewListener {

    CourseAdapter courseAdapter;
    @Inject
    ExchangeRatesContract.ExchangeRatesTabPresenterListener exchangeRatesTabPresenterListener;
    private String base = "BGN";

//    SharedPreferences sharedPreferences;
//    public static final String MY_PREFERENCE = "myPreference";
//    public static final String BASE = "Base";



    @Inject
    public ExchangeRatesTab() {
    }

    @Override
    public int getLayoutRes() {
        return R.layout.tab_exchange_rates;
    }

    @Override
    public void onFragmentCreated() {
//        sharedPreferences = requireActivity().getSharedPreferences(MY_PREFERENCE, Context.MODE_PRIVATE);

        exchangeRatesTabPresenterListener.setViewListener(this);
        setRecyclerView();
        setSearchListener();
    }

//    private void saveCurrencyPreference() {
//
//        if (sharedPreferences.contains(BASE)){
//            base = sharedPreferences.getString(BASE, "BGN");
//        } else{
//            SharedPreferences.Editor editor = myPreference.edit();
//            editor.putInt();
//            editor.apply();
//        }
//    }

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
            Toast.makeText(getContext(), "Data have been updated", Toast.LENGTH_SHORT).show();
            exchangeRatesTabPresenterListener.getCoursesFromApi(getContext(), base);
            requireActivity().invalidateOptionsMenu();
        } else if (item.getItemId() == R.id.eur) {
            this.base = "EUR";
            Toast.makeText(getContext(), "Data have been updated", Toast.LENGTH_SHORT).show();
            exchangeRatesTabPresenterListener.getCoursesFromApi(getContext(), base);
            requireActivity().invalidateOptionsMenu();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setRecyclerView() {
        binding.exchangeRatesRecyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        courseAdapter = new CourseAdapter(getContext());
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
        courseAdapter.setBase(base);
        courseAdapter.setCourseAdapterInExchangeRatesTabUsed(true);
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
