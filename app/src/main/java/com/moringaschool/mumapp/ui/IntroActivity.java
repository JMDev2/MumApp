package com.moringaschool.mumapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moringaschool.mumapp.R;

import butterknife.BindView;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {
//    @BindView(R.id.signup)
//    Button mButton;
//    @BindView(R.id.account)
//    TextView mText;
    private Button mButton;
    private TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        mButton = findViewById(R.id.signup);
        mText = findViewById(R.id.account);


        mButton.setOnClickListener(this);
        mText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mButton) {
            Intent intent = new Intent(IntroActivity.this, StatusActivity.class);
            startActivity(intent);
            finish();
        }

        if (v == mText) {
            Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
            startActivity(intent);

        };

    }
}