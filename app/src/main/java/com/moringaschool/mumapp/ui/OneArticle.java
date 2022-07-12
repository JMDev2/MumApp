package com.moringaschool.mumapp.ui;

import static com.moringaschool.mumapp.Constant.FIREBASE_USER;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.UserFirebase;
import com.moringaschool.mumapp.adapters.MessageListAdapter;
import com.moringaschool.mumapp.adapters.commentAdapter;
import com.moringaschool.mumapp.models.ArticleResponse;
import com.moringaschool.mumapp.models.Chat;
import com.moringaschool.mumapp.models.Comment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OneArticle extends AppCompatActivity {
    @BindView(R.id.floatingActionAdd)
    FloatingActionButton addCommentButton;
    @BindView(R.id.floatingActionSend)
    FloatingActionButton sendComment;
    @BindView(R.id.comment)
    EditText comment;
    DatabaseReference reference;
    private List<Comment> commentList = new ArrayList<Comment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_article);
        ButterKnife.bind(this);
        ArticleResponse articleResponse = (ArticleResponse) getIntent().getSerializableExtra("article");
        String Author = getIntent().getStringExtra("author");
        TextView Title = (TextView) findViewById(R.id.articleTitle);
        TextView author = findViewById(R.id.articleAuthor);
        TextView content = (TextView) findViewById(R.id.articleContent);
        Title.setText(articleResponse.getHeading().toUpperCase());
        author.setText(("Article by "+ Author).toUpperCase());
        content.setText(articleResponse.getArticleContent()+"\n");
        addCommentButton.setOnClickListener(V->{
            comment.setVisibility(View.VISIBLE);
            sendComment.setVisibility(View.VISIBLE);
            addCommentButton.setVisibility(View.GONE);
        });
sendComment.setOnClickListener(V->{
    String theComment = comment.getText().toString().trim();
    Comment  sentComment = new Comment(theComment,articleResponse.getAuthor(),"","");
    DatabaseReference restaurantRef = FirebaseDatabase
            .getInstance()
            .getReference("comments");
    DatabaseReference pushRef = restaurantRef.push();
   // String pushId = pushRef.getKey();
    sentComment.setUname(articleResponse.getHeading());
//                    AppUser newUser = new AppUser(email, username, phone);
//                    newUser.setPushId(pushId);
    pushRef.setValue(sentComment);
    comment.setText("");
});
getComments(articleResponse);
    }
 void getComments(ArticleResponse articleResponse){
     reference = FirebaseDatabase.getInstance().getReference("comments");
     reference.addValueEventListener(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot snapshot) {
commentList.clear();
             for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                 Comment comment = dataSnapshot.getValue(Comment.class);
                 Log.e("comment", new Gson().toJson(comment));

                 if(comment.getUname()== null){
                     return;
                 }
                 if (comment.getUname().equals(articleResponse.getHeading())) {
                     commentList.add(comment);

                 }
             }
             RecyclerView recyclerView = findViewById(R.id.commentsRecycler);
             recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
             recyclerView.setAdapter(new commentAdapter(commentList,getApplicationContext()));

         }

         @Override
         public void onCancelled(@NonNull DatabaseError error) {

         }
     });

  }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}