package com.mikulovehe.Dao;

import com.mikulovehe.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import java.util.List;

@Mapper

public interface ArticleDao {
    @ResultMap("ArticleResultMap")
    int insertArticle(Article article);

    boolean updateArticle(Article article);

    boolean deleteArticleById(Integer id);

    Article selectArticleById(int id);

    List<Article> selectAllArticles();

    List<Article> selectHomePageArticle(@Param("start") int start, @Param("num") int num);

    boolean cancelGood(int id);

    boolean good(int id);

    Integer getGoodNum(int id);

    String getImageUrlById(int id);

    int countAllArticles();

    List<Integer> selectAllArticleGoodNums();

    void addLookNum(int id);
}
