package com.example.amali.helthcaretracker.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amali.helthcaretracker.R;
import com.example.amali.helthcaretracker.core.BaseFragment;
import com.example.amali.helthcaretracker.core.ContentView;
import com.example.amali.helthcaretracker.databinding.FragmentDoctorsBinding;

@ContentView(R.layout.fragment_doctors)
public class DoctorsFragment extends BaseFragment<FragmentDoctorsBinding> {

    public DoctorsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
            }
        });
    }
}
