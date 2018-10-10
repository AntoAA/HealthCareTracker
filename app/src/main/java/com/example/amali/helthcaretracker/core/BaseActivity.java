package com.example.amali.helthcaretracker.core;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<VDB extends ViewDataBinding> extends AppCompatActivity{

    protected VDB binding;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1){
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.black, getTheme()));
        }else{
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.black));
        }

        if (getClass().isAnnotationPresent(ContentView.class)){
            final ContentView annotation = getClass().getAnnotation(ContentView.class);
            binding = DataBindingUtil.setContentView(this, annotation.value());
        }
    }

    public void replaceFragment(final Fragment fragment, final @IdRes int container){
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(container, fragment);
        fragmentTransaction.commit();

    }
}
