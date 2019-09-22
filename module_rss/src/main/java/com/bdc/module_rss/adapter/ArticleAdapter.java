package com.bdc.module_rss.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bdc.lib_common.Constants;
import com.bdc.lib_common.utils.ImageLoader;
import com.bdc.module_rss.R;
import com.prof.rssparser.Article;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private List<Article> articles;

    private Context mContext;

    public ArticleAdapter(List<Article> list, Context context) {
        this.articles = list;
        this.mContext = context;
    }

    public List<Article> getArticleList() {
        return articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rss_row, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {

        Article currentArticle = articles.get(position);

        String pubDateString;
        try {
            String sourceDateString = currentArticle.getPubDate();

            SimpleDateFormat sourceSdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
            Date date = sourceSdf.parse(sourceDateString);

            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
            pubDateString = sdf.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
            pubDateString = currentArticle.getPubDate();
        }

        viewHolder.title.setText(currentArticle.getTitle());

        ImageLoader.load(mContext,currentArticle.getImage(),viewHolder.image,false,0);

//        Picasso.get()
//                .load(currentArticle.getImage())
//                .placeholder(R.drawable.placeholder)
//                .into(viewHolder.image);

        viewHolder.pubDate.setText(pubDateString);

        StringBuilder categories = new StringBuilder();
        for (int i = 0; i < currentArticle.getCategories().size(); i++) {
            if (i == currentArticle.getCategories().size() - 1) {
                categories.append(currentArticle.getCategories().get(i));
            } else {
                categories.append(currentArticle.getCategories().get(i)).append(", ");
            }
        }

//        viewHolder.category.setText(categories.toString());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View view) {
                String title = articles.get(viewHolder.getAdapterPosition()).getTitle();
                String content = articles.get(viewHolder.getAdapterPosition()).getContent();
                ARouter.getInstance().build(Constants.MODULE_COMMON_WEBVIEW)
                        .withString("title",title)
                        .withString("content",content)
                        .navigation();


            }
        });
    }

    @Override
    public int getItemCount() {
        return articles == null ? 0 : articles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView pubDate;
        ImageView image;
//        TextView category;

        public ViewHolder(View itemView) {

            super(itemView);
            title = itemView.findViewById(R.id.title);
            pubDate = itemView.findViewById(R.id.pubDate);
            image = itemView.findViewById(R.id.image);
//            category = itemView.findViewById(R.id.categories);
        }
    }
}
