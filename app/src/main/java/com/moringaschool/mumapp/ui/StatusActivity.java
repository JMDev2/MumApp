package com.moringaschool.mumapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.moringaschool.mumapp.R;

public class StatusActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mParentBtn;
    private Button mPlanBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        mParentBtn = findViewById(R.id.parentBtn);
        mPlanBtn = findViewById(R.id.planBtn);


        mParentBtn.setOnClickListener(this);
        mPlanBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mParentBtn) {
            Intent intent = new Intent(StatusActivity.this, ChildDetailActivity.class);
            startActivity(intent);

        }
        if (v == mPlanBtn) {
            Intent intent = new Intent(StatusActivity.this, ChildDetailActivity.class);
            startActivity(intent);
            finish();
        }





    }
}