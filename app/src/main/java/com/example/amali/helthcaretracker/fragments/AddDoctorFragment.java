package com.example.amali.helthcaretracker.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amali.helthcaretracker.R;
import com.example.amali.helthcaretracker.core.BaseFragment;
import com.example.amali.helthcaretracker.core.ContentView;
import com.example.amali.helthcaretracker.databinding.FragmentAddDoctorBinding;

/**
 * Created by antonia_achim on 9/18/2018.
 */

@ContentView(R.layout.fragment_add_doctor)
public class AddDoctorFragment extends BaseFragment<FragmentAddDoctorBinding> {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return binding.getRoot();
    }
}
