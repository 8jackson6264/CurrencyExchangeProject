package com.example.currencyexchange.ui.fragments;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment extends DaggerFragment {

    public final static String TAG = BaseFragment.class.getSimpleName();

//    protected T binding;

    public abstract int getLayoutRes();
}
