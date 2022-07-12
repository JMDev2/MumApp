package com.moringaschool.mumapp.adapters;





import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.moringaschool.mumapp.Constant;
import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.UserFirebase;
import com.moringaschool.mumapp.models.ArticleResponse;
import com.moringaschool.mumapp.models.Comment;
import com.moringaschool.mumapp.ui.OneArticle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.ButterKnife;

public class commentAdapter extends RecyclerView.Adapter<commentAdapter.myHolder> {

    List<Comment> comments = new ArrayList<>();
    private Context context;
    View view;
    private DatabaseReference reference;
    List<UserFirebase> users = new ArrayList<UserFirebase>();

    public commentAdapter(List<Comment> comments, Context context) {
        this.comments = comments;
        this.context = context;

    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.comment, parent, false);
        myHolder holder = new myHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {

        Constant.reference = FirebaseDatabase.getInstance().getReference("AllUsers");
        Constant.reference.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    UserFirebase child = dataSnapshot.getValue(UserFirebase.class);
                    Constant.users.add(child);
                }
                Constant.users = Constant.users.stream().filter(user -> user.getUid().equals(comments.get(position).getUid())).collect(Collectors.toList());
                Constant.passuser = Constant.users.get(0).getName();
                holder.title.setText(Constant.passuser);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        holder.sampleText.setText(comments.get(position).getContent());

//        reference = FirebaseDatabase.getInstance().getReference("User").child(comments.get(position).getAuthor());
//      //  Log.e("author:",articles.get(position).getAuthor());
//        reference.addValueEventListener(new ValueEventListener() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    UserFirebase child = dataSnapshot.getValue(UserFirebase.class);
//                    users.add(child);
//                }
//          //      Log.e("userrs",new Gson().toJson(users));
//             //   Log.e("articles",new Gson().toJson(articles.stream().forEach(user-> user.getAuthor())));
//comments.forEach(article-> Log.e("UID",article.getAuthor()));
//                users = users.stream().filter(user-> user.getUid().equals(comments.get(position).getAuthor())).collect(Collectors.toList());
//            //    Log.e("userrs filterred",new Gson().toJson(users));
//                 String passuser = users.get(0).getName();
//                holder.itemCard.setOnClickListener(v->
//                {
//                    Intent intent = new Intent(context, OneArticle.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    intent.putExtra("author",passuser);
//                    intent.putExtra("article", comments.get(position));
//                    context.startActivity(intent);
//                });
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }


    @Override
    public int getItemCount() {
        return comments.size();
    }

    class myHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.titleInList)
        TextView title;
        @BindView(R.id.Summary)
        TextView sampleText;


        public myHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, view);

        }
    }
}