package com.example.currencyexchange.ui.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.currencyexchange.R;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {
    public static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(getLayoutRes());
        onActivityCreated();

    }
    protected abstract void onActivityCreated();
    protected abstract int getLayoutRes();
}
