package com.moringaschool.mumapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moringaschool.mumapp.R;

public class ChildDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mChildName;
    private EditText mAge;
    private Button mGirl;
    private Button mBoy;
    private Button mAnother;
    private Button mNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_detail);

        mChildName = findViewById(R.id.ChildName);
        mAge = findViewById(R.id.Age);
        mGirl = findViewById(R.id.girlBtn);
        mBoy = findViewById(R.id.boyBtn);
        mAnother = findViewById(R.id.anotherBtn);
        mNext = findViewById(R.id.nextBtn);
    }

    @Override
    public void onClick(View v) {

    }
}