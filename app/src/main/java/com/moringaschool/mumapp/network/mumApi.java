package com.moringaschool.mumapp.network;

import com.moringaschool.mumapp.User;
import com.moringaschool.mumapp.models.ArticleResponse;
import com.moringaschool.mumapp.models.Response;
import com.moringaschool.mumapp.models.SearchArticleResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface mumApi {
    @GET("get-allArticles")
    Call<Response> getAllArticles(
    );

    @GET("search-articles")
    Call<List<SearchArticleResponse>> searchArticle(
            @Query("query") String query
    );

    @GET("get-allUsers")
    Call<List<User>> getAllUsers(
    );
    @POST("post-user")
    Call<User> sendUserToServer(@Body User user);


}
