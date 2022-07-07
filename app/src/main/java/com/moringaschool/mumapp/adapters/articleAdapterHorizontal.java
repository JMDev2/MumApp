package com.moringaschool.mumapp.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.models.ArticleResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class articleAdapterHorizontal extends RecyclerView.Adapter<articleAdapterHorizontal.myHolder> {

List<ArticleResponse> articles = new ArrayList<ArticleResponse>();
    private Context context;
View view;

    public articleAdapterHorizontal(List<ArticleResponse> articles, Context context) {
        this.articles = articles;
        this.context = context;

    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.display_item, parent, false);
        myHolder holder = new myHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
holder.title.setText(articles.get(position).getHeading());
holder.sampleText.setText(articles.get(position).getArticleContent());
    }


    @Override
    public int getItemCount() {
        return articles.size();
    }
    class myHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.Title)
        TextView title;
        @BindView(R.id.sampleText)
        TextView sampleText;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,view);

        }
    }
}
