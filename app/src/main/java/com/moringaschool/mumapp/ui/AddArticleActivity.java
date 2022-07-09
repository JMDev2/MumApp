package com.moringaschool.mumapp.ui;

import static com.moringaschool.mumapp.Constant.FIREBASE_USER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.User;
import com.moringaschool.mumapp.models.ArticleResponse;
import com.moringaschool.mumapp.network.mumApi;
import com.moringaschool.mumapp.network.mumClient;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddArticleActivity extends AppCompatActivity {
    @BindView(R.id.heading)
    EditText heading;
    @BindView(R.id.content)
    EditText content;
    @BindView(R.id.buttonpost)
    Button post;
    mumApi mumApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_article);
        ButterKnife.bind(this);
        post.setOnClickListener(v -> {
            String title = heading.getText().toString().trim();
            String postitself = content.getText().toString().trim();
            mumApi = mumClient.getClient();
            Call<ArticleResponse> call = mumApi.sendPost(new ArticleResponse(FIREBASE_USER, 0, title, postitself, 1));
            call.enqueue(new Callback<ArticleResponse>() {
                @Override
                public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                    if (response.isSuccessful()) {
                        Log.e("added", new Gson().toJson(response.body()));
                        Intent intent = new Intent(AddArticleActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<ArticleResponse> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        });


    }
}