package com.example.newsapp.Views;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;


public class NewsDetails extends AppCompatActivity {
    ImageView mimageView;
     TextView mTitle;
     TextView mDescription;
    ImageView imageView;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_details);
        imageView=findViewById(R.id.back_image);
        mimageView=findViewById(R.id.news_image);
         mTitle=findViewById(R.id.title_text);
        mDescription=findViewById(R.id.description);
        Intent intent=getIntent();
        mTitle.setText(intent.getStringExtra("title"));
        mDescription.setText(intent.getStringExtra("description"));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
         intent.getStringExtra("image");
        Glide.with(this).load( intent.getStringExtra("image")).into( mimageView);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}