package com.moringaschool.mumapp;


import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.mumapp.ui.OneArticle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Constant {
    public static DatabaseReference reference;
    public static String GENDER = "none";
    public static final String BASE_URL = "https://mom-apigp.herokuapp.com/";
    public static boolean signup;

    public static final String FIREBASE_CHILD_USER = "users";
    // public static  boolean L
    public static String FIREBASE_USER = " ";
    public static boolean addChild = true;
    public static List<UserFirebase> users = new ArrayList<UserFirebase>();
   public static String passuser;

    public static DatabaseReference getReference() {
        return reference;
    }

    public static void setReference(DatabaseReference reference) {
        Constant.reference = reference;
    }

    public static String getGENDER() {
        return GENDER;
    }

    public static void setGENDER(String GENDER) {
        Constant.GENDER = GENDER;
    }

    public static boolean isSignup() {
        return signup;
    }

    public static void setSignup(boolean signup) {
        Constant.signup = signup;
    }

    public static String getFirebaseUser() {
        return FIREBASE_USER;
    }

    public static void setFirebaseUser(String firebaseUser) {
        FIREBASE_USER = firebaseUser;
    }

    public static boolean isAddChild() {
        return addChild;
    }

    public static void setAddChild(boolean addChild) {
        Constant.addChild = addChild;
    }

    public static List<UserFirebase> getUsers() {
        return users;
    }

    public static void setUsers(List<UserFirebase> users) {
        Constant.users = users;
    }

    public static String getPassuser() {
        return passuser;
    }
//
//    public static void setPassuser(String passuser) {
//        Constant.passuser = passuser;
//    }


}


