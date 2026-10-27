package com.mikulovehe.pojo;

import java.util.Date;

public class Article {
    private Integer id;
    private String title;
    private String addTime;
    private String context;
    private String goodNum;
    private String imgUrl;
    private String excerpt;
    private String lookNum;
    private String author;


    public Article() {
    }

    // 检查文章这三个值是否符合要求用
    public Article(String title, String context, String excerpt,String author) {
        this.title = title;
        this.context = context;
        this.excerpt = excerpt;
        this.author = author;
    }

    //添加文章
    public Article(String title, String addTime, String context, String imgUrl, String excerpt,String author) {
        this.title = title;
        this.addTime = addTime;
        this.context = context;
        this.imgUrl = imgUrl;
        this.excerpt = excerpt;
        this.author = author;
    }

    //查询文章
    public Article(String title, String context, String goodNum, String lookNum, String imgUrl, String excerpt, String addTime,String author) {
        this.title = title;
        this.context = context;
        this.goodNum = goodNum;
        this.lookNum = lookNum;
        this.imgUrl = imgUrl;
        this.excerpt = excerpt;
        this.addTime = addTime;
        this.author = author;
    }

    //根据id查询文章
    public Article(String title, Integer id, String context, String goodNum, String lookNum, String imgUrl, String excerpt, String addTime,String author) {
        this.title = title;
        this.id = id;
        this.context = context;
        this.goodNum = goodNum;
        this.lookNum = lookNum;
        this.imgUrl = imgUrl;
        this.excerpt = excerpt;
        this.addTime = addTime;
        this.author = author;
    }

    //根据id修改
    public Article(Integer id, String title, String context, String imgUrl, String excerpt) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.imgUrl = imgUrl;
        this.excerpt = excerpt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {

        this.addTime = addTime;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(String goodNum) {
        this.goodNum = goodNum;
    }

    public String getLookNum() {
        return lookNum;
    }

    public void setLookNum(String lookNum) {
        this.lookNum = lookNum;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", addTime='" + addTime + '\'' +
                ", context='" + context + '\'' +
                ", goodNum='" + goodNum + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", excerpt='" + excerpt + '\'' +
                ", lookNum='" + lookNum + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
