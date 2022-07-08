package com.moringaschool.mumapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatUserAdapter extends RecyclerView.Adapter<ChatUserAdapter.viewHolder> {
    
    public ChatUserAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    List<User> list;
View view;
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.dispaly_all, parent, false);
        ChatUserAdapter.viewHolder holder = new ChatUserAdapter.viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
