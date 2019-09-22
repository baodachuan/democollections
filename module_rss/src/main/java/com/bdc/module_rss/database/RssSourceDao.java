package com.bdc.module_rss.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.bdc.module_rss.bean.RssSourceBean;

import java.util.List;

@Dao
public interface RssSourceDao {
    @Query("select * from RssSourceBean")
    List<RssSourceBean> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertAll(RssSourceBean ...rssSourceBeans);

    @Update
    void update(RssSourceBean... rssSourceBeans);

    @Delete
    void delete(RssSourceBean rssSourceBean);

}


