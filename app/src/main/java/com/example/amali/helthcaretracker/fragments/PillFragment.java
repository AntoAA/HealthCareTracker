package com.example.amali.helthcaretracker.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amali.helthcaretracker.models.Pill;
import com.example.amali.helthcaretracker.R;
import com.example.amali.helthcaretracker.adapters.PillListAdapter;
import com.example.amali.helthcaretracker.core.BaseFragment;
import com.example.amali.helthcaretracker.core.ContentView;
import com.example.amali.helthcaretracker.databinding.FragmentPillsBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonia_achim on 9/18/2018.
 */

@ContentView(R.layout.fragment_pills)
public class PillFragment extends BaseFragment<FragmentPillsBinding> {

    private List<Pill> pills;
    private PillListAdapter adapter;

    public PillFragment() {
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

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        binding.piRecyclerView.setLayoutManager(layoutManager);
        initializeAdapter();
        updateAdapter();

    }

    private void updateAdapter() {
        pills.add(new Pill("Nurofen"));
        pills.add(new Pill("Paracetamol"));
        adapter.clearItems();
        adapter.addAll(pills);
    }

    private void initializeAdapter() {
        pills = new ArrayList<>();
        adapter = new PillListAdapter(pills);
        binding.piRecyclerView.setAdapter(adapter);
    }
}
