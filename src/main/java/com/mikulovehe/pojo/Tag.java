package com.mikulovehe.pojo;

public class Tag {
    public int id;
    public String name;
    public String addTime;

    public Tag() {
    }

    public Tag(int id, String name, String addTime) {
        this.id = id;
        this.name = name;
        this.addTime = addTime;
    }

    public Tag(String name, String addTime) {
        this.name = name;
        this.addTime = addTime;
    }

    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tag(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addTime='" + addTime + '\'' +
                '}';
    }
}
