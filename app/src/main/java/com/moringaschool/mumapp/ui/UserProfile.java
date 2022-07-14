package com.moringaschool.mumapp.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
import com.moringaschool.mumapp.models.AppUser;
import com.moringaschool.mumapp.models.Child;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserProfile extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.profileName)
    TextView profileName;
    @BindView(R.id.profileHandle)
    TextView profileHandle;
    @BindView(R.id.numberOfPosts)
    TextView posts;
    @BindView(R.id.following)
    TextView following;
    @BindView(R.id.follwers)
    TextView followers;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.signemail)
    EditText email;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.Signup1)
    Button mSave;
    private DatabaseReference reference;
    private List<Child> children = new ArrayList<Child>();
    RecyclerView recyclerView;
    UserFirebase user;
    private List<UserFirebase> users = new ArrayList<UserFirebase>();


//    private AppUser mAppUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
Constant.addChild = false;
     user = (UserFirebase) getIntent().getSerializableExtra("user");
        reference = FirebaseDatabase.getInstance().getReference("User").child(user.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    UserFirebase child = dataSnapshot.getValue(UserFirebase.class);
                    users.add(child);
                }
                TextView email = findViewById(R.id.profileHandle);
                TextView name = findViewById(R.id.profileName);
                TextView phone = findViewById(R.id.phonenumber);
                TextView posts = findViewById(R.id.numberOfPosts);
                TextView followers = findViewById(R.id.follwers);
                TextView following= findViewById(R.id.following);
                phone.setText(users.get(0).getPhoneNo());
                name.setText(users.get(0).getName());
                email.setText(users.get(0).getEmail());
                posts.setText(String.valueOf(users.get(0).getPosts()));
                followers.setText(String.valueOf(users.get(0).getFollowers()));
                following.setText(String.valueOf(users.get(0).getFollowing()));
                ImageView image = (ImageView) findViewById(R.id.userImage);
                if (!users.get(0).getImageUrl().equals("")||users.get(0).getImageUrl()!=null) {
                    Glide.with(getApplicationContext()).load(users.get(0).getImageUrl()).into(image);
                }
//                childAdapter childAdapter = new childAdapter(children, getActivity());
//                recyclerView.setAdapter(childAdapter);
//                RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
//                recyclerView.setLayoutManager(gridLayoutManager);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        recyclerView = findViewById(R.id.childrenRecyc);
        refresh();

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
                    childAdapter childAdapter = new childAdapter(children, getApplicationContext());
                    recyclerView.setAdapter(childAdapter);
                    RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
                    recyclerView.setLayoutManager(gridLayoutManager);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    }

    @Override
    public void onClick(View v) {

    }

}
//
//    @Override
//    public void onClick(View v) {
//        if(v == mSave){
////            String name = username.getText().toString().trim();
////            String myPhone = phone.getText().toString().trim();
////            String myEmail = email.getText().toString().trim();
////            Log.d("UserProfile", "values"+ name + myEmail + myPhone);
////
////            AppUser appUser = new AppUser(myEmail,name,myPhone);
////
////            DatabaseReference userRef = FirebaseDatabase
////                    .getInstance()
////                    .getReference(Constant.FIREBASE_CHILD_USER);
////                    userRef.push().setValue(appUser);
//        }
//
//    }
//}
//    Button mButton;
//    EditText username;
//    EditText email;
//    EditText phone ;
//
//    EditText password;
//    EditText confirmPassword;
//
//
//    FirebaseAuth auth;
//    private AppUser mAppUser;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);
//        return root;
//    }
//
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        phone = view.findViewById(R.id.phone);
//        username= view.findViewById(R.id.username);
//        email = view.findViewById(R.id.signemail);
//
//        password= view.findViewById(R.id.password);
//        confirmPassword = view.findViewById(R.id.confirmpass);
//
//        auth = FirebaseAuth.getInstance();
//        mButton  = view.findViewById(R.id.Signup1);
//        mButton.setOnClickListener(this);
//
//    };
//
//public void userDetails(){
//        String name = username.getText().toString().trim();
//        String myEmail = email.getText().toString().trim();
//        String myPhone = phone.getText().toString().trim();
//        String pass = password.getText().toString().trim();
//        Toast.makeText(getContext(),name, Toast.LENGTH_SHORT).show();
//
//        String confirmPassword = this.confirmPassword.getText().toString().trim();
//        signup(myEmail,pass,name, myPhone);
//
//
//        }
//
//public void signup(String email, String password,String username, String phone){
//        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//@Override
//public void onComplete(@NonNull Task<AuthResult> task) {
//
//        if (task.isSuccessful()) {
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//        Log.d("name", username);
//        createFirebaseUserProfile(Objects.requireNonNull(task.getResult().getUser()),username);
//        Log.d("created user", "wertyuioptyuio");
//        DatabaseReference restaurantRef = FirebaseDatabase
//        .getInstance()
//        .getReference("User").child(uid);
//        DatabaseReference pushRef = restaurantRef.push();
//        String pushId = pushRef.getKey();
//        AppUser newUser = new AppUser(email,username,phone);
//        newUser.setPushId(pushId);
//        pushRef.setValue(newUser);
//
//        Intent intent = new Intent(getContext(), MainActivity.class);
//        startActivity(intent);
//
//        } else {
//        Log.d("SignupTabFragment", "Signup Error", task.getException());
//        Toast.makeText(getContext(), "Please Try Again", Toast.LENGTH_LONG).show();
//
//        }
//
//
//        }
//        });
//        }
//private void createFirebaseUserProfile(final FirebaseUser user, String name) {
//
//        UserProfileChangeRequest addProfileName = new UserProfileChangeRequest.Builder()
//        .setDisplayName(name)
//        .build();
//
//        user.updateProfile(addProfileName)
//        .addOnCompleteListener(new OnCompleteListener<Void>() {
//
//@Override
//public void onComplete(@NonNull Task<Void> task) {
//        if (task.isSuccessful()) {
//        Log.d("creating user", Objects.requireNonNull(user.getDisplayName()));
//        } else {
//        Log.d("ffffaaaaaiiilll", Objects.requireNonNull(user.getDisplayName()));
//
//        }
//        }
//
//        });
//
//        }
//
////SAVING THE USER OBJECT
//
//@Override
//public void onClick(View v) {
//        if(v == mButton){
//        userDetails();
////            String name = username.getText().toString().trim();
////            String myPhone = phone.getText().toString().trim();
////            String myEmail = email.getText().toString().trim();
////            Log.d("UserProfile", "values"+ name + myEmail + myPhone);
////
////            AppUser appUser = new AppUser(myEmail,name,myPhone);
////
////            DatabaseReference userRef = FirebaseDatabase
////                    .getInstance()
////                    .getReference(Constant.FIREBASE_CHILD_USER).child("1");
////            userRef.setValue(appUser);
////
////            Intent intent = new Intent(getContext(), MainActivity.class);
////            startActivity(intent);
//
//
//        }
//        }
//        }
