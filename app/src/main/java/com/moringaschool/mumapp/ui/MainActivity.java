package com.moringaschool.mumapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.models.ArticleResponse;
import com.moringaschool.mumapp.network.mumApi;
import com.moringaschool.mumapp.network.mumClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {
    private RecyclerView articleRV;

    // Arraylist for storing data
    private ArrayList<ArticleModel> articleModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        articleRV = findViewById(R.id.idRVArticle);
        // here we have created new array list and added data to it.
        articleModelArrayList = new ArrayList<>();
        articleModelArrayList.add(new ArticleModel("mother Principle", 4, R.drawable.blogimage1));
        articleModelArrayList.add(new ArticleModel("Nursing", 3, R.drawable.blogimage1));
        articleModelArrayList.add(new ArticleModel("parenting one", 4, R.drawable.blogimage1));
        articleModelArrayList.add(new ArticleModel("my Home", 4, R.drawable.blogimage1));
        articleModelArrayList.add(new ArticleModel("love", 4, R.drawable.blogimage1));
        articleModelArrayList.add(new ArticleModel("How to be a Mum", 4, R.drawable.blogimage1));
        articleModelArrayList.add(new ArticleModel("home", 4, R.drawable.blogimage1));

        // we are initializing our adapter class and passing our arraylist to it.
        ArticleAdapter articleAdapter = new ArticleAdapter(this, articleModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        articleRV.setLayoutManager(linearLayoutManager);
        articleRV.setAdapter(articleAdapter);

        mumApi mumApi = mumClient.getClient();

        Call<List<ArticleResponse>> call = mumApi.getArticle();

    }
}