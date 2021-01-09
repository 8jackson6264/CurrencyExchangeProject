package com.example.currencyexchange.ui.fragments;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.currencyexchange.R;
import com.example.currencyexchange.core.contracts.SavedCoursesContract;
import com.example.currencyexchange.data.Course;
import com.example.currencyexchange.databinding.TabSavedCoursesBinding;
import com.example.currencyexchange.ui.adapters.CourseAdapter;

import java.util.List;

import javax.inject.Inject;

public class SavedCoursesTab extends BaseFragment<TabSavedCoursesBinding>
        implements SavedCoursesContract.SavedCoursesTabViewListener {

    CourseAdapter courseAdapter;

    @Inject
    SavedCoursesContract.SavedCoursesTabPresenterListener savedCoursesTabPresenterListener;

    @Inject
    public SavedCoursesTab() {
    }

    @Override
    public int getLayoutRes() {
        return R.layout.tab_saved_courses;
    }

    @Override
    public void onFragmentCreated() {
        savedCoursesTabPresenterListener.setViewListener(this, getContext());
        setRecyclerView();
    }

    @Override
    public void onResume() {
        super.onResume();
        savedCoursesTabPresenterListener.getCourseListFromDB();
    }

    @Override
    public void setOptionsMenu(Menu menu) {
        menu.getItem(0).setVisible(false);
        menu.getItem(1).setVisible(false);
        menu.getItem(2).setOnMenuItemClickListener((item) -> refreshSavedCoursesTab());
    }

    @Override
    public void setCourseAdapterList(List<Course> courses) {
        courseAdapter.setCourses(courses);
        courseAdapter.setCourseAdapterInExchangeRatesTabUsed(false);
    }

    private void setRecyclerView() {
        binding.savedCoursesRecyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        courseAdapter = new CourseAdapter(getContext());
        binding.savedCoursesRecyclerView.setAdapter(courseAdapter);
    }

    private boolean refreshSavedCoursesTab(){
        savedCoursesTabPresenterListener.getCourseListFromDB();
        Toast.makeText(getContext(), "Data have been updated", Toast.LENGTH_SHORT).show();
        return false;
    }
}
