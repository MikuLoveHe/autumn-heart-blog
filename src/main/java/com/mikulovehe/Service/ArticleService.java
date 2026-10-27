package com.mikulovehe.Service;

import com.mikulovehe.pojo.Article;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public interface ArticleService {

    String insertArticle(Article article);

    String deleteArticleById(int id) throws IOException;

    String updateArticle(Article article);

    String selectArticleById(int id);

    List<Article> selectAllArticles();

    List<Article> selectHomePageArticle(int start, int num);

    String cancelGood(int id);

    String good(int id);

    Integer getGoodNum(int id);

    Integer totalArticle();

    Map<String,Integer> totalArticleAndLikes();
}
