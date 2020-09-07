package com.example.newsapp.Model;



import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {
    @SerializedName("status")
   String status;
   int totalResults;
   @SerializedName("articles")
   List<Article> articles;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
