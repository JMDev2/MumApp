package com.moringaschool.mumapp.network;

import com.moringaschool.mumapp.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class mumClient {
    public static Retrofit retrofit = null;

    public static mumApi getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(mumApi.class);
    }
}
