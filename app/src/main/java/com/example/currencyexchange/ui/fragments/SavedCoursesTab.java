package com.example.currencyexchange.ui.fragments;

import android.view.Menu;

import com.example.currencyexchange.R;
import com.example.currencyexchange.databinding.TabSavedCoursesBinding;

import javax.inject.Inject;

public class SavedCoursesTab extends BaseFragment<TabSavedCoursesBinding> {

    @Inject
    public SavedCoursesTab() {
    }

    @Override
    public int getLayoutRes() {
        return R.layout.tab_saved_courses;
    }

    @Override
    public void onFragmentCreated() {

    }

    @Override
    public void setOptionsMenu(Menu menu) {
        menu.getItem(0).setVisible(false);
    }

}
