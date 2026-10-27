package com.mikulovehe.pojo;

public class Comment {
    private int id;
    private String context;
    private String goodNum;
    private String addTime;
    private int articleId;
    private int userId;

    public Comment(int id, String context, String goodNum, String addTime, int articleId, int userId) {
        this.id = id;
        this.context = context;
        this.goodNum = goodNum;
        this.addTime = addTime;
        this.articleId = articleId;
        this.userId = userId;
    }

    public Comment(String context, String addTime, int articleId, int userId) {
        this.context = context;
        this.addTime = addTime;
        this.articleId = articleId;
        this.userId = userId;
    }

    public Comment(int id ,String context) {
        this.id =id;
        this.context = context;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", context='" + context + '\'' +
                ", goodNum='" + goodNum + '\'' +
                ", addTime='" + addTime + '\'' +
                ", articleId=" + articleId +
                ", userId=" + userId +
                '}';
    }
}
