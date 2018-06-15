package com.smarttahi.minicqupt.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.ViewHolder.ViewHolderPool;

import java.util.ArrayList;

public class mAdapter extends RecyclerView.Adapter<ViewHolderPool>{

    private ArrayList<Integer> image_normal;
    private ArrayList<String> texts_normal;


    public mAdapter(ArrayList<Integer> image_normal, ArrayList<String> texts_normal) {
        this.image_normal = image_normal;
        this.texts_normal = texts_normal;}
    @NonNull
    @Override
    public ViewHolderPool onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.normal_item, parent, false);
        return new ViewHolderPool(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPool holder, int position) {
        holder.imageView_normal.setImageResource(image_normal.get(position));
        holder.content.setText(texts_normal.get(position));
    }

    @Override
    public int getItemCount() {
        return image_normal.size();
    }
}
