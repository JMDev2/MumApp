package com.moringaschool.mumapp.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.mumapp.Constant;
import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.models.AppUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserProfile extends AppCompatActivity implements View.OnClickListener {
//    @BindView(R.id.profileName)
//    TextView profileName;
//    @BindView(R.id.profileHandle)
//    TextView profileHandle;
//    @BindView(R.id.numberOfPosts)
//    TextView posts;
//    @BindView(R.id.following)
//    TextView following;
//    @BindView(R.id.follwers)
//    TextView followers;
//    @BindView(R.id.username)
//    EditText username;
//    @BindView(R.id.signemail)
//    EditText email;
//    @BindView(R.id.phonee)
//    EditText phone;
//    @BindView(R.id.Signup1)
//    Button mSave;

//    private AppUser mAppUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
//        ButterKnife.bind(this);
//        mSave.setOnClickListener(this);

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
