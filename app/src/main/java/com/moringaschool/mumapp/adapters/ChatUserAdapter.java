package com.moringaschool.mumapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseUser;
import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.User;
import com.moringaschool.mumapp.UserFirebase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatUserAdapter extends RecyclerView.Adapter<ChatUserAdapter.viewHolder> {
    private Context context;
    List<UserFirebase> list = new ArrayList<UserFirebase>();
    View view;
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
holder.personName.setText(list.get(position).getName());
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
