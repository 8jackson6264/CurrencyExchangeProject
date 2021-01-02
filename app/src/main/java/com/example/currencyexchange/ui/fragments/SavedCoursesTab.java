package com.example.currencyexchange.ui.fragments;

import com.example.currencyexchange.R;

import javax.inject.Inject;

public class SavedCoursesTab extends BaseFragment {

    @Inject
    public SavedCoursesTab() {
    }

    @Override
    public int getLayoutRes() {
        return R.layout.tab_saved_courses;
    }
}
