package com.example.newsapp.Networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    public static final String BASE_URL="https://newsapi.org/v2/";
    public JsonPlaceHolderApi api;
    private static Client instance;

    public Client() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api=retrofit.create(JsonPlaceHolderApi.class);
    }
    public static Client getInstance() {
        if(instance==null){
            instance=new Client();

        }
        return instance;
    }

}
