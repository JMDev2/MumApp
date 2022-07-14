package com.moringaschool.mumapp.adapters;


import static com.moringaschool.mumapp.Constant.FIREBASE_USER;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.UserFirebase;
import com.moringaschool.mumapp.models.ArticleResponse;
import com.moringaschool.mumapp.ui.OneArticle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.ButterKnife;

public class articleAdapterVertical extends RecyclerView.Adapter<articleAdapterVertical.myHolder> {

List<ArticleResponse> articles = new ArrayList<ArticleResponse>();
    private Context context;
View view;
    private DatabaseReference reference;
    List<UserFirebase> users = new ArrayList<UserFirebase>();

    public articleAdapterVertical(List<ArticleResponse> articles, Context context) {
        this.articles = articles;
        this.context = context;

    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.dispaly_all, parent, false);
        myHolder holder = new myHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
holder.title.setText(articles.get(position).getHeading());
holder.sampleText.setText(articles.get(position).getArticleContent());


        reference = FirebaseDatabase.getInstance().getReference("User").child(articles.get(position).getAuthor());
      //  Log.e("author:",articles.get(position).getAuthor());
        reference.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    UserFirebase child = dataSnapshot.getValue(UserFirebase.class);
                    users.add(child);
                }
          //      Log.e("userrs",new Gson().toJson(users));
             //   Log.e("articles",new Gson().toJson(articles.stream().forEach(user-> user.getAuthor())));
              articles.forEach(article-> Log.e("UID",article.getAuthor()));
                users = users.stream()
                        .filter(user-> user
                                .getUid()
                                .equals(articles
                                        .get(position)
                                        .getAuthor()))
                        .collect(Collectors.toList());
                if (!users.get(0).getImageUrl().equals("")||!(users.get(0).getImageUrl()==null))
                {
                    Glide.with(context).load(users.get(0).getImageUrl()).into(holder.image);
                }
                //    Log.e("userrs filterred",new Gson().toJson(users));
                 String passuser = users.get(0).getName();
                String url = users.get(0).getImageUrl();
                holder.itemCard.setOnClickListener(v->
                {
                    Intent intent = new Intent(context, OneArticle.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("author",passuser);
                    intent.putExtra("url",url);
                    intent.putExtra("article",articles.get(position));
                    context.startActivity(intent);
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    @Override
    public int getItemCount() {
        return articles.size();
    }
    class myHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.titleInList)
        TextView title;
        @BindView(R.id.Summary)
        TextView sampleText;
        @BindView(R.id.cardView)
        CardView itemCard;
        @BindView(R.id.idIVCourseImage)
        ImageView image;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,view);

        }
    }
}
