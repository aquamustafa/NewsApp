package com.example.newsapp.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newsapp.Model.Article;
import com.example.newsapp.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.newsholder> {
    List<Article> news=new ArrayList<>();
     Context context;
    listItemOnlick listItemOnlick;
     public interface listItemOnlick{
         void onitemclicked (int position);
     }
     public void setData(List<Article> newss){
         this.news=newss;
         notifyDataSetChanged();

     }

    public newsAdapter(Context context,listItemOnlick listItemOnlick) {
        this.context=context;
        this.listItemOnlick=listItemOnlick;
    }

    @NonNull
    @Override
    public newsholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.news_item,viewGroup,false);
        return new newsholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull newsholder newsholder, int i) {
         newsholder.authorText.setText(news.get(i).getAuthor());
        newsholder.titileText.setText( news.get(i).getTitle());
        newsholder.sourceText.setText(news.get(i).getSource().getSourceName());

        Glide.with(context).load(news.get(i).getUrlToImage()).into(newsholder.imageView);

     }

    @Override
    public int getItemCount() {
        if(news!=null){
        return news.size();
        }

        return 0;
    }




    class newsholder extends RecyclerView.ViewHolder implements View.OnClickListener{
         TextView titileText;
        TextView sourceText;
        TextView authorText;
        ImageView imageView;

        public newsholder(@NonNull View itemView) {
            super(itemView);
            titileText=itemView.findViewById(R.id.text_view_title);
            sourceText=itemView.findViewById(R.id.source_txt_view);
            authorText=itemView.findViewById(R.id.author_textview);
            imageView=itemView.findViewById(R.id.news_image);
            itemView.setOnClickListener(this);
         }

        @Override
        public void onClick(View v) {
          int position=getAdapterPosition();
            listItemOnlick.onitemclicked(position);
        }
    }
}
