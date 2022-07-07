package com.moringaschool.mumapp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.adapters.articleAdapterHorizontal;
import com.moringaschool.mumapp.models.ArticleResponse;
import com.moringaschool.mumapp.models.Response;
import com.moringaschool.mumapp.network.mumApi;
import com.moringaschool.mumapp.network.mumClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    public List<ArticleResponse> Response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mumApi mumApi = mumClient.getClient();

        Call<Response> call = mumApi.getAllArticles();

        mButton = (Button) findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call.enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(@NonNull Call<Response> call, @NonNull retrofit2.Response<Response> response) {

                        if (response.isSuccessful()) {
                            Response = response.body().getArticleResponse();
                            Toast.makeText(getApplicationContext(),"a toast",Toast.LENGTH_LONG);
                            articleAdapterHorizontal horizontal = new articleAdapterHorizontal(Response,getApplicationContext());
                            RecyclerView horizontalRecyclerView = findViewById(R.id.top_sell_recycler_view);
                            horizontalRecyclerView.setAdapter(horizontal);
                            horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, true));

                        }else{

                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
            }
        });
    }
}


//    private void apiCall(){
//
//        });
//    }
//}