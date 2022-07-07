package com.moringaschool.mumapp.ui;

import static com.moringaschool.mumapp.Constant.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moringaschool.mumapp.R;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Button btnAdd = (Button) findViewById(R.id.buttonIntro);
        TextView tvAdd = (TextView) findViewById(R.id.alreadyhave);
        tvAdd.setOnClickListener(v->{
            Intent intent = new Intent(IntroActivity.this, StatusActivity.class);
            startActivity(intent);
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup = true;
                Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
                startActivity(intent);
            }

        });
    }
}