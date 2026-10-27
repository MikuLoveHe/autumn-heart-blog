package com.mikulovehe.Dao;

import com.mikulovehe.DTO.ArticleWithTagsDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ArticleWithTagsDaoTest {
    @Autowired
    private ArticleWithTagsDao articleWithTagsDao;

    @Test
    void setArticleWithTags() {
       List<ArticleWithTagsDTO> a = articleWithTagsDao.selectArticleWithTags();
        a.forEach(System.out::println);
    }

    @Test
    void selectArticleWithTagsByArticleId() {
        System.out.println(articleWithTagsDao.selectArticleWithTagsByArticleId(7));
    }

    @Test
    void selectArticleWithTagsByPage() {
        articleWithTagsDao.selectArticleWithTagsByPage(0,6).forEach(System.out::println);
    }
    @Test
    void search(){
       // articleWithTagsDao.searchArticlesCondition("1",1,10).forEach(System.out::println);
    }
}
