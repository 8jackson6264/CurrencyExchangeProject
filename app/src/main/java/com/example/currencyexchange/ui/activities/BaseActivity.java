package com.example.currencyexchange.ui.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import androidx.databinding.ViewDataBinding;

import com.example.currencyexchange.R;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity <T extends ViewDataBinding> extends DaggerAppCompatActivity {
    public static final String TAG = BaseActivity.class.getSimpleName();

    protected T binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(getLayoutRes());
        binding = DataBindingUtil.setContentView(this, getLayoutRes());
        onActivityCreated();

    }
    protected abstract void onActivityCreated();
    protected abstract int getLayoutRes();

}
