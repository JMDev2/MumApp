package com.moringaschool.mumapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.User;

public class ListAdapter extends ArrayAdapter<User> {
    public ListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){ {
        User user = getItem(position);
                if (convertView == null){
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent, false);


                }
        ImageView imageView = convertView.findViewById(R.id.profile_pic);
        TextView userName = convertView.findViewById(R.id.personName);
        TextView lastMsg = convertView.findViewById(R.id.lastMessage);
        TextView time = convertView.findViewById(R.id.msgtime);

//        imageView.setImageResource(user.imageId);
//        userName.setText(user.name);
//        lastMsg.setText(user.lastMessage);
//        time.setText(user.lastMsgTime);




                return super.getView(position, convertView, parent);
    }

}}
