package com.bdc.moudule_android_arch.dataBase;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.bdc.moudule_android_arch.bean.ArticleEntity;

import java.util.List;

/**
 * Created by arvinljw on 2018/12/17 11:04
 * Function：
 * Desc：
 */
@Dao
public interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<ArticleEntity> articles);

    @Query("select * from article order by publishTime desc")
    List<ArticleEntity> getArticles();
}
