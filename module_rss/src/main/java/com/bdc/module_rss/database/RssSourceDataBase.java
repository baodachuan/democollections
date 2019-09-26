package com.bdc.module_rss.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.bdc.module_rss.bean.RssSourceBean;

@Database(entities = {RssSourceBean.class},version = 1)
public abstract class RssSourceDataBase extends RoomDatabase {
    public static final String DATABASE_NAME = "rss_source";

    public abstract RssSourceDao getRssDao();

}
