package com.moringaschool.mumapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.UserFirebase;
import com.moringaschool.mumapp.adapters.ChatUserAdapter;
import com.moringaschool.mumapp.adapters.childAdapter;
import com.moringaschool.mumapp.models.Child;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private DatabaseReference reference;
    private List<UserFirebase> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatactivity);
        RecyclerView recyclerView = findViewById(R.id.chatRecyclerView);
        reference = FirebaseDatabase.getInstance().getReference("AllUsers");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    UserFirebase user = dataSnapshot.getValue(UserFirebase.class);
                    users.add(user);
                //    Log.e("useeeeeer",new Gson().toJson(user));
                }
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
}