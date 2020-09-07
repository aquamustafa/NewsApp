package com.example.newsapp.Views;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.newsapp.Adapters.newsAdapter;
import com.example.newsapp.Model.Article;
import com.example.newsapp.Model.News;
import com.example.newsapp.Model.Source;
import com.example.newsapp.Networking.Client;
import com.example.newsapp.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
  */
public class NewsFragment extends Fragment implements newsAdapter.listItemOnlick {

    String country="us";
    Source sourcee ;
     List<Article> newss=new ArrayList<>();
    RecyclerView recyclerView;
    newsAdapter adapter;
    TextView textView;
    String category;
    int state;

    // state =0 means we want to get topNews and no category
    //state=1 means we want to get news  under specific category
    public static NewsFragment newInstance(String Category,int i) {
        NewsFragment fragment = new NewsFragment();

        if(i==0){
            fragment.state=0;
            Log.d("fragment","state=0");
            return fragment;
        }
        if(i==1) {
            fragment.category = Category;
            fragment.state=1;
            Log.d("fragment","state=1");
            return fragment;
        }

        return fragment;
        }
    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View recent=inflater.inflate(R.layout.fragment_most_recent, container, false);
        return recent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter=new newsAdapter(getContext(),this);
        recyclerView=view.findViewById(R.id.recent_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);


        sourcee=new Source();
        if(state==0) {

            Client.getInstance().api.getNews(country, "de0783df9e1e4ecbadab1b844a920837").enqueue(new Callback<News>() {
                @Override
                public void onResponse(Call<News> call, Response<News> response) {
//                    Log.d("shoot", response.errorBody().toString());
                   // Log.d("shoot", response.message().toString());
                   // Log.d("shoot", String.valueOf(response.code()));
                    if (response.isSuccessful() && response.body() != null) {

                        newss = response.body().getArticles();
                        adapter.setData(newss);
                    }

                }

                @Override
                public void onFailure(Call<News> call, Throwable t) {

                     Log.d("shooot", t.getMessage());


                }
            });
        }
        else{
            Client.getInstance().api.get_category(country,category,"de0783df9e1e4ecbadab1b844a920837").enqueue(new Callback<News>() {
                @Override
                public void onResponse(Call<News> call, Response<News> response) {
//                    Log.d("shoot", response.errorBody().toString());
                  //  Log.d("shoot", response.message().toString());
                 //   Log.d("shoot", String.valueOf(response.code()));
                    if (response.isSuccessful() && response.body() != null) {

                        newss = response.body().getArticles();
                        adapter.setData(newss);
                    }

                }

                @Override
                public void onFailure(Call<News> call, Throwable t) {

                     Log.d("shooot", t.getMessage());


                }
            });
        }

        }


    @Override
    public void onitemclicked(int position) {
        Intent intent=new Intent(getActivity(), NewsDetails.class);
        intent.putExtra("title",newss.get(position).getTitle());
        intent.putExtra("description",newss.get(position).getDescription());
        intent.putExtra("source",newss.get(position).getSource().getSourceName());
        intent.putExtra("image",newss.get(position).getUrlToImage());
        startActivity(intent);
    }
}
