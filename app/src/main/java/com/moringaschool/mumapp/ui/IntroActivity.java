package com.moringaschool.mumapp.ui;

import static com.moringaschool.mumapp.Constant.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringaschool.mumapp.R;

public class IntroActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener AuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        auth = FirebaseAuth.getInstance();

        AuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();


                if (user != null) {
                    Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }

            }
        };
        Button btnAdd = (Button) findViewById(R.id.buttonIntro);
        TextView tvAdd = (TextView) findViewById(R.id.alreadyhave);
        tvAdd.setOnClickListener(v->{
            Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
            startActivity(intent);
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup = true;
                Intent intent = new Intent(IntroActivity.this, StatusActivity.class);

                startActivity(intent);
            }

        });
    }
    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(AuthStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (AuthStateListener != null) {
            auth.removeAuthStateListener(AuthStateListener);
        }
    }
}