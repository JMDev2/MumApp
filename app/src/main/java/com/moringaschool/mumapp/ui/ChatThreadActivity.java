package com.moringaschool.mumapp.ui;

import static com.moringaschool.mumapp.Constant.FIREBASE_USER;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
import com.moringaschool.mumapp.adapters.MessageListAdapter;
import com.moringaschool.mumapp.adapters.childAdapter;
import com.moringaschool.mumapp.models.Chat;
import com.moringaschool.mumapp.models.Child;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ChatThreadActivity extends AppCompatActivity {

    private MessageListAdapter mMessageAdapter;
    private List<Chat> messageList = new ArrayList<Chat>();
    private DatabaseReference reference;
    static boolean refresh = true;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_thread);
        Constant.FIREBASE_USER = FirebaseAuth.getInstance().getCurrentUser().getUid();


        //  Intent intent = new Intent();
        UserFirebase user = (UserFirebase) getIntent().getSerializableExtra("chatFriend");
        getSupportActionBar().setTitle(user.getName());
        Log.e("userr", new Gson().toJson(user));
        Button send = findViewById(R.id.button_gchat_send);
        EditText message = findViewById(R.id.edit_gchat_message);
        send.setOnClickListener(v -> {
            Chat chat = new Chat();
            chat.setMessage(message.getText().toString().trim());
            chat.setSender(FIREBASE_USER);
            chat.setReceiver(user.getUid());
            LocalDateTime today = LocalDateTime.now();
            String formattedDate = today.format(DateTimeFormatter.ofPattern("HH:mm"));
           // Log.e("date",formattedDate);
            chat.setCreatedAt(formattedDate);
            String receiver = user.getUid();
            chat.setReceiver(receiver);
            DatabaseReference reff = FirebaseDatabase
                    .getInstance()
                    .getReference("Chats").child(FIREBASE_USER);
            DatabaseReference pushReff = reff.push();
            pushReff.setValue(chat);
            DatabaseReference reff2 = FirebaseDatabase
                    .getInstance()
                    .getReference("Chats").child(user.getUid());
            DatabaseReference pushRef2 = reff2.push();
            pushRef2.setValue(chat);
            message.setText("");
        });

        reference = FirebaseDatabase.getInstance().getReference("Chats").child(FIREBASE_USER);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messageList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Chat message = dataSnapshot.getValue(Chat.class);
                    assert message != null;
                    if (message.getSender().equals(user.getUid()) && message.getReceiver().equals(FIREBASE_USER) || message.getSender().equals(FIREBASE_USER) && message.getReceiver().equals(user.getUid())) {
                        messageList.add(message);
                    }
                    Log.e("messages", new Gson().toJson(message));
                }
                //  mMessageAdapter = new MessageListAdapter(getApplicationContext(), messageList);


                RecyclerView mMessageRecycler;
                mMessageRecycler = (RecyclerView) findViewById(R.id.recycler_gchat);
                mMessageAdapter = new MessageListAdapter(getApplicationContext(), messageList);
                mMessageRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                mMessageRecycler.setAdapter(mMessageAdapter);
                mMessageRecycler.scrollToPosition(messageList.size()-1);


              //  LocalDate today = LocalDate.now();

//                LocalDate date = LocalDate.now();
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
//                String text = date.format(formatter);
//                Log.e("date",text);
//                LocalDate parsedDate = LocalDate.parse(text, formatter);

                // mMessageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}