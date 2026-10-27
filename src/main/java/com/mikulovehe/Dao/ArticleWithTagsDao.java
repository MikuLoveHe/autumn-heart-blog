package com.mikulovehe.Dao;

import com.mikulovehe.DTO.ArticleWithTagsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import java.util.List;

@Mapper
public interface ArticleWithTagsDao {
    @ResultMap("ArticleWithTagsResultMap")
    List<ArticleWithTagsDTO> selectArticleWithTags();

    ArticleWithTagsDTO selectArticleWithTagsByArticleId(int ArticleId);

    List<ArticleWithTagsDTO> selectArticleWithTagsByPage(@Param("start") int start, @Param("num") int num);

    boolean connectArticleAndTags(@Param("articleId") int articleId, @Param("tagId") int tagId);

    Integer deleteArticleAllWithTagsById(@Param("articleId") int articleId);

    List<String> selectArticleTagById(int id);

    List<String> selectUnusedTags(@Param("tagNameList") List<String> tagNameList);
    int countArticlesCondition(@Param("keyword")String keyword);

    List<Integer> searchArticleIdsCondition(@Param("keyword")String keyword,@Param("page")int page,@Param("pageSize")int pageSize);

    List<ArticleWithTagsDTO> selectArticlesWithTagsByIds(@Param("articleIds")List<Integer> articleIds);
}
