package com.moringaschool.mumapp.ui;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.fragments.LoginTabFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFrameLayout = findViewById(R.id.fragment_container);
        setFragment(new LoginTabFragment());
    }

    private void setFragment(Fragment loginActivity) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_right)
                .replace(mFrameLayout.getId(), loginActivity).commit();

    }
}