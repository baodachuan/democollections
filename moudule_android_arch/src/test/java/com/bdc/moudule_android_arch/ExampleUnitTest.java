package com.bdc.moudule_android_arch;

import androidx.lifecycle.LiveData;

import com.bdc.moudule_android_arch.bean.ArticleEntity;
import com.bdc.moudule_android_arch.bean.PageList;
import com.bdc.moudule_android_arch.bean.Response;
import com.bdc.moudule_android_arch.repos.ArticlesRepo;
import com.bumptech.glide.load.engine.Resource;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testLoadData(){
        LiveData<Resource<Response<PageList<ArticleEntity>>>> indexArticles = ArticlesRepo.getIndexArticles(1);
        Resource<Response<PageList<ArticleEntity>>> value = indexArticles.getValue();
        Response<PageList<ArticleEntity>> pageListResponse = value.get();
        PageList<ArticleEntity> data = pageListResponse.getData();
        List<ArticleEntity> data1 = data.getData();
        System.out.println(data1);


    }
}