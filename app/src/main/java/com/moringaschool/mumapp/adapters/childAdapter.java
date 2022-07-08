package com.moringaschool.mumapp.adapters;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.models.ArticleResponse;
import com.moringaschool.mumapp.models.Child;
import com.moringaschool.mumapp.ui.ChildDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class childAdapter extends RecyclerView.Adapter<childAdapter.myHolder> {

    List<Child> list = new ArrayList<Child>();
    private Context context;
    View view;

    public childAdapter(List<Child> children, Context context) {
        this.list = children;
        this.context = context;

    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.child_item, parent, false);
        myHolder holder = new myHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        if (position == list.size()) {
            holder.childsName.setVisibility(View.INVISIBLE);
            holder.childImage.setVisibility(View.INVISIBLE);
            holder.addChild.setVisibility(View.VISIBLE);
            holder.addChild.setOnClickListener(v -> {
                Intent intent = new Intent(context, ChildDetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            });

        }
        if (position < list.size()) {
            holder.childImage.setImageResource(R.drawable.emoticon);
            holder.childsName.setText(list.get(position).getName());
        }
    }


    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    class myHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.childImage)
        ImageView childImage;
        @BindView(R.id.childsName)
        TextView childsName;
        @BindView(R.id.addChild)
        TextView addChild;


        public myHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, view);

        }
    }
}
