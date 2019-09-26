package com.bdc.module_rss.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bdc.module_rss.R;
import com.bdc.module_rss.bean.RssSourceBean;

import java.util.List;

public class SubScribeAdapter extends RecyclerView.Adapter<SubScribeAdapter.ViewHolder> {
    private List<RssSourceBean> datas;
    private Context mContext;

    public SubScribeAdapter(List<RssSourceBean> datas, Context mContext) {
        this.datas = datas;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rss_rv_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RssSourceBean rssSourceBean = datas.get(position);
        holder.nameTextView.setText(rssSourceBean.getSourceName());
        int articleTotleNumbers = rssSourceBean.getArticleTotleNumbers();
        holder.numberTextView.setText(String.valueOf(articleTotleNumbers));

    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView imageView;
        TextView nameTextView;
        TextView numberTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.source_image);
            nameTextView = itemView.findViewById(R.id.source_name);
            numberTextView = itemView.findViewById(R.id.source_number);
        }
    }
}
