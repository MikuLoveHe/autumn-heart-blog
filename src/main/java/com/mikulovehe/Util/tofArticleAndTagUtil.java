package com.mikulovehe.Util;

import com.mikulovehe.DTO.ArticleWithTagsDTO;
import com.mikulovehe.pojo.Article;
import com.mikulovehe.pojo.Tag;

public class tofArticleAndTagUtil {
    // 判断文章内容是否符合要求
    public static void tofArticle(Article article) {

        if (article == null) {
            throw new IllegalArgumentException("文章为空");
        }
        if (article.getTitle() == null || article.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("文章标题不能为空");
        }
        if (article.getTitle().length() > 20) {  // 将长度检查提前
            throw new IllegalArgumentException("标题不能超过20字符");
        }
        if (article.getContext() == null || article.getContext().trim().isEmpty()) {
            throw new IllegalArgumentException("文章内容不能为空");
        }
        if (article.getExcerpt() == null || article.getExcerpt().trim().isEmpty()) {
            throw new IllegalArgumentException("文章摘要不能为空");
        }
        if (article.getExcerpt().length() > 80) {
            throw new IllegalArgumentException("摘要不能超过80个字符");
        }
        if (article.getAuthor() == null || article.getAuthor().trim().isEmpty()) {
            throw new IllegalArgumentException("作者不能为空");
        }
        if (article.getAuthor().length() > 30) {
            throw new IllegalArgumentException("名称不能超过30个字符");
        }
    }

    public static void tofTags(Tag tag) {
        if (tag == null) {
            throw new IllegalArgumentException("不能添加空标签");
        } else if (tag.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("不能添加空标签");
        } else if (tag.getName().length() > 20) {
            throw new IllegalArgumentException("标签不能超过20个字符");
        }
    }
}
