package com.example.newsapp.Model;


import com.google.gson.annotations.SerializedName;

public class Source {


    String id;

    @SerializedName("name")
    String sourceName;

    public String getId() {
        return id;
    }

    public String getSourceName() {
        return sourceName;
    }
}
