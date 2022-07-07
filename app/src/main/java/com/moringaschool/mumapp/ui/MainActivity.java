package com.moringaschool.mumapp.ui;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.adapters.ImageAdapter;
import com.moringaschool.mumapp.adapters.articleAdapterHorizontal;
import com.moringaschool.mumapp.network.mumApi;
import com.moringaschool.mumapp.network.mumClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
  private static
  com.moringaschool.mumapp.models.Response result = new com.moringaschool.mumapp.models.Response();
    Gson gson = new Gson();
    RecyclerView recyclerView;
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        viewpager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(getApplicationContext());
        viewpager.setAdapter(adapter);

        TabLayout tablayout = this.findViewById(R.id.tabLayout);

        tablayout.selectTab(tablayout.getTabAt(0));
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    return;
                }
                if (tab.getPosition() == 2) {
                    Intent intent = new Intent(MainActivity.this, UserProfile.class);
                    startActivity(intent);
                }

                if (tab.getPosition() == 1) {
                    Intent intent = new Intent(MainActivity.this, UserProfile.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        apiCall();
        mumApi mumApi = mumClient.getClient();
        Call<com.moringaschool.mumapp.models.Response> call = mumApi.getAllArticles();
        call.enqueue(new Callback<com.moringaschool.mumapp.models.Response>() {
            @Override
            public void onResponse(Call<com.moringaschool.mumapp.models.Response> call, Response<com.moringaschool.mumapp.models.Response> response) {
                if (response.isSuccessful()) {
                    result = response.body();
                   // Log.e("thisis", gson.toJson(result));
                    assert result != null;
                    RecyclerView.LayoutManager gridLayoutManager;
                    gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, true));
                    articleAdapterHorizontal horizontal = new articleAdapterHorizontal(result.getArticleResponse(), getApplicationContext());
                    recyclerView.setAdapter(horizontal);
                    Log.e("thisis", gson.toJson(result));
                }
            }

            @Override
            public void onFailure(Call<com.moringaschool.mumapp.models.Response> call, Throwable t) {

            }

        });
//        for (int i = 0; i < 1000;i++) {
//
//
//            Toast.makeText(getApplicationContext(), gson.toJson(result), Toast.LENGTH_LONG);
//        }
    }
}


//        mumApi mumApi = mumClient.getClient();
//
//        Call<List<ArticleResponse>> call = mumApi.getArticle();
//
////        mButton = (Button) findViewById(R.id.button1);
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                call.enqueue(new Callback<List<ArticleResponse>>() {
//                    @Override
//                    public void onResponse(Call<List<ArticleResponse>> call, Response<List<ArticleResponse>> response) {
//                        if (response.isSuccessful()) {
//
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<ArticleResponse>> call, Throwable t) {
//                    }
//                });
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//}


//    private void apiCall(){
//
//        });
//    }
//}