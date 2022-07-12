package com.moringaschool.mumapp.ui;

import static com.moringaschool.mumapp.Constant.FIREBASE_USER;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.moringaschool.mumapp.Constant;
import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.UserFirebase;
import com.moringaschool.mumapp.adapters.ChatUserAdapter;
import com.moringaschool.mumapp.adapters.MessageListAdapter;
import com.moringaschool.mumapp.adapters.childAdapter;
import com.moringaschool.mumapp.models.Chat;
import com.moringaschool.mumapp.models.Child;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ChatActivity extends AppCompatActivity {

    private DatabaseReference reference;
    private List<UserFirebase> users = new ArrayList<>();
    private List<Chat> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatactivity);




        Constant.FIREBASE_USER = FirebaseAuth.getInstance().getCurrentUser().getUid();

        RecyclerView recyclerView = findViewById(R.id.chatRecyclerView);
        reference = FirebaseDatabase.getInstance().getReference("AllUsers");
        reference.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    UserFirebase user = dataSnapshot.getValue(UserFirebase.class);
                    users.add(user);
                }
               users = users.stream().filter(user-> !user.getUid().equals(FIREBASE_USER)).collect(Collectors.toList());
                ChatUserAdapter adapter = new ChatUserAdapter(getApplicationContext(),users);
                recyclerView.setAdapter(adapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
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