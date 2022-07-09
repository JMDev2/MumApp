package com.moringaschool.mumapp.adapters;

import static com.moringaschool.mumapp.Constant.FIREBASE_USER;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.User;
import com.moringaschool.mumapp.UserFirebase;
import com.moringaschool.mumapp.models.Chat;
import com.moringaschool.mumapp.ui.ChatThreadActivity;
import com.moringaschool.mumapp.ui.UserProfile;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatUserAdapter extends RecyclerView.Adapter<ChatUserAdapter.viewHolder> {
    private Context context;
    List<UserFirebase> list = new ArrayList<UserFirebase>();
    View view;
    private List<Chat> messageList = new ArrayList<Chat>();
    private DatabaseReference reference;
    public ChatUserAdapter(Context context, List<UserFirebase> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.list_item, parent, false);
        ChatUserAdapter.viewHolder holder = new ChatUserAdapter.viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        reference = FirebaseDatabase.getInstance().getReference("Chats").child(FIREBASE_USER);
        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messageList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Chat message = dataSnapshot.getValue(Chat.class);
                    assert message != null;
                    if (message.getSender().equals(list.get(position).getUid()) && message.getReceiver().equals(FIREBASE_USER) || message.getSender().equals(FIREBASE_USER) && message.getReceiver().equals(list.get(position).getUid())) {
                        messageList.add(message);
                    }
                    holder.lastMessage.setText(messageList.get(messageList.size()-1).getMessage());
//                    if(messageList.get(messageList.size()-1).getReceiver().equals(FIREBASE_USER)){
//                        holder.lastMessage.setTextColor(R.drawable.blue_button);
//                    }

                    holder.time.setText(messageList.get(messageList.size()-1).getCreatedAt());

                    Log.e("messages", new Gson().toJson(message));
                }





            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


holder.personName.setText(list.get(position).getName());
holder.personName.setOnClickListener(v->{
    Intent intent = new Intent(context, ChatThreadActivity.class);
    intent.putExtra("chatFriend",list.get(position));
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
});
holder.profile_pic.setOnClickListener(V->{
    Intent intent = new Intent(context, UserProfile.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    intent.putExtra("user",list.get(position));
    context.startActivity(intent);
});
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.personName)
        TextView personName;
        @BindView(R.id.msgtime)
        TextView time;
        @BindView(R.id.lastMessage)
        TextView lastMessage;
        @BindView(R.id.profile_pic)
        ImageView profile_pic;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
