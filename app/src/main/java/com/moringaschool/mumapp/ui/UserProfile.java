package com.moringaschool.mumapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.moringaschool.mumapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserProfile extends AppCompatActivity {
    @BindView(R.id.profileName) TextView profileName;
    @BindView(R.id.profileHandle) TextView profileHandle;
    @BindView(R.id.numberOfPosts) TextView posts;
    @BindView(R.id.following) TextView following;
    @BindView(R.id.follwers) TextView followers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);


//        profileName.setText(user.getName());
//        profileHandle.setText(user.getHandle());

    }
}