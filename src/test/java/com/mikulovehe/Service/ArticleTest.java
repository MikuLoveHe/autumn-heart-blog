package com.mikulovehe.Service;

import com.mikulovehe.pojo.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArticleTest {
    @Autowired
    private ArticleService articleService;

    @Test
    void selectArticleById() {
        System.out.println(articleService.selectArticleById(2));
    }

    @Test
    void insertArticle() {
        articleService.insertArticle(null);
    }
}
