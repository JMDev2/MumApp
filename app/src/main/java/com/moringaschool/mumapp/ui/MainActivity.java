package com.moringaschool.mumapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.models.ArticleResponse;
import com.moringaschool.mumapp.network.mumApi;
import com.moringaschool.mumapp.network.mumClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mumApi mumApi = mumClient.getClient();

        Call<List<ArticleResponse>> call = mumApi.getArticle();

        mButton = (Button) findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call.enqueue(new Callback<List<ArticleResponse>>() {
                    @Override
                    public void onResponse(Call<List<ArticleResponse>> call, Response<List<ArticleResponse>> response) {
                        if (response.isSuccessful()) {

                        }
                    }

                    @Override
                    public void onFailure(Call<List<ArticleResponse>> call, Throwable t) {

                    }
                });
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}



//    private void apiCall(){
//
//        });
//    }
//}