package com.moringaschool.mumapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.User;
import com.moringaschool.mumapp.adapters.ListAdapter;
import com.moringaschool.mumapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        int[] imageId = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i};

        String[] name = {"Diana", "Kieru", "Joseph", "Mwangi", "Cheche", "Sylvia", "Levi", "Opunga", "David"};
        String[] lastMessage = {"Hey", "ssup", "yooh", "whats up?", "Dinner?", "Alright", "Nimefika", "I love you", "IDC"};
        String[] lastMsgTime = {"8:00pm", "9:00am", "7:15pm", "9:12am", "6:17pm", "6:30pm", "5:58am", "4:14am", "6:23am"};
        String[] phoneNo = {"089000789", "089000789", "089000789", "089000789", "089000789", "089000789", "089000789", "089000789", "089000789"};
        String[] country = {"Kenya", "Zambia", "columbia", "china", "uganda", "tanzania", "congo", "nigeria", "morocco"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for (int i = 0; i < imageId.length; i++) {

            User user = new User(name[i], lastMessage[i], lastMsgTime[i], phoneNo[i], country[i], imageId[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this, userArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnClickListener(new AdapterView.OnItemClickListener()) {

            @Override
            public void onItemClick (AdapterView <?>, parent, View view,int position, long id);
        }

}
}