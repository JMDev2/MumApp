package com.moringaschool.mumapp.adapters;


import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;

public class articleAdapter extends RecyclerView.Adapter<articleAdapter.myHolder> {


    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    class myHolder extends RecyclerView.ViewHolder{
        public myHolder(@NonNull View itemView) {
            super(itemView);


        }
    }
}
