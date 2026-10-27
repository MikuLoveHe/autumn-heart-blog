package com.mikulovehe.Service;

import com.mikulovehe.DTO.ArticleWithTagsDTO;

import java.util.List;
import java.util.Map;

public interface ArticleWithTagsService {
    List<ArticleWithTagsDTO> selectArticleWithTagsByPage(int start, int num);

    ArticleWithTagsDTO selectArticleWithTagsById(int id);

    List<ArticleWithTagsDTO> selectArticleWithTags();

    String insertArticleWithTags(ArticleWithTagsDTO articleWithTags);

    String updateArticleWithTags(ArticleWithTagsDTO articleWithTags);

    Map<String,Object> searchArticlesCondition(String keyword, int page, int pageSize);
}
