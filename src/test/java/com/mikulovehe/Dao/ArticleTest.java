package com.mikulovehe.Dao;

import com.mikulovehe.pojo.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class ArticleTest {

    @Autowired
    private ArticleDao article;

    @Test
    void ArticleDaoTest() {
        // 添加
        /*LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = localDate.format(formatter);
        article.insertArticle(new Article("111", formattedDate, "111","img","excerpt"));
*/
        //更新
        /*boolean f = article.updateArticle(new Article(2,"222", "222", "222", "222"));
        System.out.println(f);*/

        // 删除
        /*boolean f = article.deleteArticleById(1);
        System.out.println(f);*/

        // 根据id查询
        //System.out.println(article.selectArticleById(6));

        // 查询全部
        System.out.println(article.selectAllArticles());

    }


    @Test
    void DateTest() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = localDateTime.format(formatter);
        System.out.println(formattedDate);
    }

    @Test
    void selectById() {
        System.out.println(article.selectArticleById(7));
    }

}
