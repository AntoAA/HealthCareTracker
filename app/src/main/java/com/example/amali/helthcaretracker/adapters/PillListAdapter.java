package com.example.amali.helthcaretracker.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amali.helthcaretracker.models.Pill;
import com.example.amali.helthcaretracker.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonia_achim on 9/13/2018.
 */
public class PillListAdapter extends BaseRecyclerViewAdapter<Pill, PillListAdapter.PillItemViewHolder> {

    private Context context;
    private List<Pill> pills;

    public PillListAdapter() {
        this.pills = new ArrayList<>();
    }

    public PillListAdapter(List<Pill> pills) {
        this.pills = pills;
    }

    @NonNull
    @Override
    public PillListAdapter.PillItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new PillItemViewHolder(inflate(parent, R.layout.simple_row));
    }

    @Override
    public void onBindViewHolder(@NonNull PillListAdapter.PillItemViewHolder holder, int position) {
        final Pill currentPill = getItem(position);
        holder.pilltextView.setText(currentPill.getName());
    }

    public class PillItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView pillImageView;
        private TextView pilltextView;
        public PillItemViewHolder(View itemView) {
            super(itemView);
            pillImageView = itemView.findViewById(R.id.cardImageView);
            pilltextView = itemView.findViewById(R.id.cardTextView);
        }
    }
}
