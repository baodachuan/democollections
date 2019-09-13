package com.bdc.moudule_android_arch.dataBase;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.bdc.moudule_android_arch.bean.ArticleEntity;

/**
 * Created by arvinljw on 2018/12/17 11:02
 * Function：
 * Desc：
 */
@Database(entities = {ArticleEntity.class}, version = 1, exportSchema = false)
public abstract class ArticleDatabase extends RoomDatabase {
    abstract ArticleDao getArticleDao();
}
