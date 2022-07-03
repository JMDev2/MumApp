package com.moringaschool.mumapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.moringaschool.mumapp.R;

public class SplashScreen extends AppCompatActivity {

    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //This method will be executed once the timer is over
                // Start your app main activity
                Intent intent = new Intent(SplashScreen.this, UserProfile.class);
                startActivity(intent);
                finish();
            }
        }, 3000);


    }

}