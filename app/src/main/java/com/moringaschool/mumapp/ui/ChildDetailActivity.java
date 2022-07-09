package com.moringaschool.mumapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.models.AppUser;
import com.moringaschool.mumapp.models.Child;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChildDetailActivity extends AppCompatActivity {
    @BindView(R.id.enterChildName) EditText childsName;
    @BindView(R.id.enterAge) EditText age;
    @BindView(R.id.buttonBoy) Button boy;
    @BindView(R.id.buttongirl) Button girl;
    @BindView(R.id.anotherChild) Button anotherChild;
    @BindView(R.id.AddchildNext)
    Button next;
    Child child;
    String gender;
    String name;
    int childAge;
    FirebaseDatabase ref;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_detail);
        ButterKnife.bind(this);
        boy.setOnClickListener(v -> {
            gender = "male";
        });
        girl.setOnClickListener(v -> {
            gender = "female";
        });

        next.setOnClickListener(v -> {
            if(gender == null){
                Toast.makeText(this,"Pick A Gender",Toast.LENGTH_LONG).show();
           return ;
            }
            name = childsName.getText().toString();
            childAge = Integer.parseInt(age.getText().toString());
            child = new Child(name, childAge, gender);
            FirebaseAuth auth = FirebaseAuth.getInstance();
            FirebaseUser user = auth.getCurrentUser();
            String uid = user.getUid();
            DatabaseReference ref = FirebaseDatabase
                    .getInstance()
                    .getReference("children").child(uid);
            DatabaseReference pushRef = ref.push();
            String pushId = pushRef.getKey();
            child.setUid(pushId);
            pushRef.setValue(child);
            Intent intent = new Intent(ChildDetailActivity.this, MainActivity.class);
            startActivity(intent);

        });
        anotherChild.setOnClickListener(v -> {
            if(gender == null){
                Toast.makeText(this,"Pick A Gender",Toast.LENGTH_LONG).show();
                return ;
            }
            name = childsName.getText().toString();
            childAge = Integer.parseInt(age.getText().toString());
            child = new Child(name, childAge, gender);
            FirebaseAuth auth = FirebaseAuth.getInstance();
            FirebaseUser user = auth.getCurrentUser();
            String uid = user.getUid();
            DatabaseReference ref = FirebaseDatabase
                    .getInstance()
                    .getReference("children").child(uid);
            DatabaseReference pushRef = ref.push();
            String pushId = pushRef.getKey();
            child.setUid(pushId);
            pushRef.setValue(child);
            Intent intent = new Intent(ChildDetailActivity.this, ChildDetailActivity.class);
            startActivity(intent);

        });

    }
}