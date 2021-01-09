package com.example.currencyexchange.ui.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
        setDialogAlertForNetworkDisconnection();
        onActivityCreated();

    }
    protected abstract void onActivityCreated();
    protected abstract int getLayoutRes();

    public boolean isNetworkConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public void setDialogAlertForNetworkDisconnection() {
        if (!isNetworkConnected()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Check your internet connection and try again")
                    .setTitle("Not connected").setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    recreate();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}
