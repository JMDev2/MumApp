package com.moringaschool.mumapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
import com.moringaschool.mumapp.adapters.childAdapter;
import com.moringaschool.mumapp.models.Child;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

public class Profile extends Fragment {
    private DatabaseReference reference;
    private List<Child> children = new ArrayList<Child>();
    RecyclerView recyclerView;
    FirebaseUser user;
    private List<UserFirebase> users = new ArrayList<UserFirebase>();


    public Profile() {
        // Required empty public constructor
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Constant.addChild =true;
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("User").child(user.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    UserFirebase child = dataSnapshot.getValue(UserFirebase.class);
                    users.add(child);
                }
                TextView email = view.findViewById(R.id.profileHandle);
                TextView name = view.findViewById(R.id.profileName);
                TextView phone = view.findViewById(R.id.phonenumber);
                TextView posts = view.findViewById(R.id.numberOfPosts);
                TextView followers = view.findViewById(R.id.follwers);
                TextView following= view.findViewById(R.id.following);
                phone.setText(users.get(0).getPhoneNo());
                name.setText(users.get(0).getName());
                email.setText(users.get(0).getEmail());
                posts.setText(String.valueOf(users.get(0).getPosts()));
                followers.setText(String.valueOf(users.get(0).getFollowers()));
                following.setText(String.valueOf(users.get(0).getFollowing()));

//                childAdapter childAdapter = new childAdapter(children, getActivity());
//                recyclerView.setAdapter(childAdapter);
//                RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
//                recyclerView.setLayoutManager(gridLayoutManager);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        recyclerView = view.findViewById(R.id.childrenRecyc);
        refresh();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_user_profile, container, false);
    }

    void refresh() {


        for (int i = 0; i <= 0; i++) {
            reference = FirebaseDatabase.getInstance().getReference("children").child(user.getUid());
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        Child child = dataSnapshot.getValue(Child.class);
                        children.add(child);
                    }
                    childAdapter childAdapter = new childAdapter(children, getActivity());
                    recyclerView.setAdapter(childAdapter);
                    RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
                    recyclerView.setLayoutManager(gridLayoutManager);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    }
}