package com.example.newsapp.Networking;


import com.example.newsapp.Model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("top-headlines")
    Call<News> getNews(
            @Query("country") String cc,
            @Query("apiKey") String apiKey);

            @GET("top-headlines")
            Call<News> get_category(
            @Query("country") String cc,
            @Query("category")String category,
             @Query("apiKey") String apiKey);

    }

