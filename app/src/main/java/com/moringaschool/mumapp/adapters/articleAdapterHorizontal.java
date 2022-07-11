package com.moringaschool.mumapp.adapters;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.UserFirebase;
import com.moringaschool.mumapp.models.ArticleResponse;
import com.moringaschool.mumapp.ui.OneArticle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class articleAdapterHorizontal extends RecyclerView.Adapter<articleAdapterHorizontal.myHolder> {

    List<ArticleResponse> articles = new ArrayList<ArticleResponse>();
    private Context context;
    View view;
    private DatabaseReference reference;
    List<UserFirebase> users = new ArrayList<UserFirebase>();

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
//        if (articles.size() == 1) {
//            Log.e("POSITION", String.valueOf(position));
//            holder.title.setText(articles.get(0).getHeading());
//            holder.sampleText.setText(articles.get(0).getArticleContent());
//        }else {
            holder.title.setText(articles.get(position).getHeading());
            holder.sampleText.setText(articles.get(position).getArticleContent());
        reference = FirebaseDatabase.getInstance().getReference("User").child(articles.get(position).getAuthor());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    UserFirebase child = dataSnapshot.getValue(UserFirebase.class);
                    users.add(child);
                }
                holder.itemCard.setOnClickListener(v->
                {
                    Intent intent = new Intent(context, OneArticle.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("author",users.get(0).getName());
                    intent.putExtra("article",articles.get(position));
                    context.startActivity(intent);
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

       // }
    }


    @Override
    public int getItemCount() {
        return articles.size();
    }

    class myHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.Title)
        TextView title;
        @BindView(R.id.sampleText)
        TextView sampleText;
        @BindView(R.id.itemCard)
        CardView itemCard;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, view);

        }
    }
}
