package com.mikulovehe.DTO;

import java.util.List;

public class ArticleWithTagsDTO {
    private int articleId;
    private String articleTitle;
    private String articleAddTime;
    private String articleContext;
    private String articleExcerpt;
    private String articleGoodNum;
    private String articleLookNum;
    private String articleImgUrl;
    private List<String> tagsName;
    private String author;

    public ArticleWithTagsDTO() {
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleAddTime() {
        return articleAddTime;
    }

    public void setArticleAddTime(String articleAddTime) {
        this.articleAddTime = articleAddTime;
    }

    public String getArticleContext() {
        return articleContext;
    }

    public void setArticleContext(String articleContext) {
        this.articleContext = articleContext;
    }

    public String getArticleExcerpt() {
        return articleExcerpt;
    }

    public void setArticleExcerpt(String articleExcerpt) {
        this.articleExcerpt = articleExcerpt;
    }

    public String getArticleGoodNum() {
        return articleGoodNum;
    }

    public void setArticleGoodNum(String articleGoodNum) {
        this.articleGoodNum = articleGoodNum;
    }

    public String getArticleLookNum() {
        return articleLookNum;
    }

    public void setArticleLookNum(String articleLookNum) {
        this.articleLookNum = articleLookNum;
    }

    public String getArticleImgUrl() {
        return articleImgUrl;
    }

    public void setArticleImgUrl(String articleImgUrl) {
        this.articleImgUrl = articleImgUrl;
    }

    public List<String> getTagsName() {
        return tagsName;
    }

    public void setTagsName(List<String> tagsName) {
        this.tagsName = tagsName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ArticleWithTagsDTO{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleAddTime='" + articleAddTime + '\'' +
                ", articleContext='" + articleContext + '\'' +
                ", articleExcerpt='" + articleExcerpt + '\'' +
                ", articleGoodNum='" + articleGoodNum + '\'' +
                ", articleLookNum='" + articleLookNum + '\'' +
                ", articleImgUrl='" + articleImgUrl + '\'' +
                ", tagsName=" + tagsName +
                ", author='" + author + '\'' +
                '}';
    }
}
