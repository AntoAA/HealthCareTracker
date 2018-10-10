package com.example.amali.helthcaretracker.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by antonia_achim on 9/13/2018.
 */
public abstract class BaseRecyclerViewAdapter<E, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    /**
     * Type header
     */
    protected static final int TYPE_HEADER = 0;

    /**
     * Type normal
     */
    protected static final int TYPE_NORMAL = 1;

    /**
     * The items of type E of the recycler adapter.
     */
    private List<E> mItems;

    /**
     * Constructor with empty list of items
     */
    protected BaseRecyclerViewAdapter() {
        mItems = new ArrayList<>();
    }

    /**
     * Constructor with given list of items
     *
     * @param items The Items to initialize the adapter with
     */
    public BaseRecyclerViewAdapter(final List<E> items) {
        mItems = items;
    }

    public void removeItem(final int position) {
        if (mItems == null) {
            mItems = new ArrayList<>();
        }
        if (mItems.size() > position) {
            mItems.remove(position);
        }
        notifyDataSetChanged();
    }

    public void addItem(final E item) {
        if (mItems == null) {
            mItems = new ArrayList<>();
        }
        mItems.add(item);
        notifyDataSetChanged();
    }

    public void addAll(final Collection<E> items) {
        if (mItems == null) {
            mItems = new ArrayList<>();
        }
        mItems.addAll(items);
    }

    public void clearItems() {
        if ((mItems != null) && (mItems.isEmpty())) {
            mItems = new ArrayList<>();
        }
        notifyDataSetChanged();
    }

    public E getItem(final int position) {
        return mItems != null && !mItems.isEmpty() && position < mItems.size() ? mItems.get(position) : null;
    }

    public List<E> getItems() {
        return ((mItems != null) && (mItems.isEmpty())) ? new ArrayList<E>() : mItems;
    }

    public void setItems(final List<E> items) {
        setItems(items, false);
    }

    public void setItems(final List<E> items, final boolean notifyDataSetChanged) {
        mItems = items;
        if (notifyDataSetChanged) {
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    /**
     * Inflates a view using the given layoutresource id.
     *
     * @param parent      The parent view group
     * @param layoutResId The id of the layout to be inflated
     * @return The inflated view
     */
    protected View inflate(final ViewGroup parent, final int layoutResId) {
        return LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
    }

}
