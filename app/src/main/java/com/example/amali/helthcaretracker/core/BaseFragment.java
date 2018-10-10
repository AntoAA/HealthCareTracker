package com.example.amali.helthcaretracker.core;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by antonia_achim on 9/12/2018.
 */
public abstract class BaseFragment<VDB extends ViewDataBinding> extends Fragment {

    protected VDB binding;

    public BaseFragment() {
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            onFragmentVisible();
        } else {
            onFragmentInvisible();
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getClass().isAnnotationPresent(ContentView.class)) {
            final ContentView annotation = getClass().getAnnotation(ContentView.class);
            binding = DataBindingUtil.inflate(inflater, annotation.value(), container, false);
            return binding.getRoot();
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    protected void onFragmentInvisible() {
    }

    private void onFragmentVisible() {
    }

    protected void replaceFragment(final Fragment fragment, @IdRes final int container, String tagForBackStack){
        final FragmentManager fragmentManager = getChildFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(tagForBackStack != null){
            fragmentTransaction.addToBackStack(tagForBackStack);
        }

        fragmentTransaction.replace(container, fragment).commit();
    }
}
