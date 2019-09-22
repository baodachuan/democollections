package com.bdc.module_rss.bean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RssSourceBean {
    @PrimaryKey
    private int id;
    @ColumnInfo(name = "sourceName")
    String sourceName;
    @ColumnInfo(name = "url")
    String url;
    @ColumnInfo(name = "total")
    int articleTotleNumbers;

    @ColumnInfo(name = "notRead")
    int articleNotReadNumber;

    @ColumnInfo(name = "subscirbeDate")
    String subscirbeDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getArticleTotleNumbers() {
        return articleTotleNumbers;
    }

    public void setArticleTotleNumbers(int articleTotleNumbers) {
        this.articleTotleNumbers = articleTotleNumbers;
    }

    public int getArticleNotReadNumber() {
        return articleNotReadNumber;
    }

    public void setArticleNotReadNumber(int articleNotReadNumber) {
        this.articleNotReadNumber = articleNotReadNumber;
    }

    public String getSubscirbeDate() {
        return subscirbeDate;
    }

    public void setSubscirbeDate(String subscirbeDate) {
        this.subscirbeDate = subscirbeDate;
    }


}
