package com.mikulovehe.pojo;


public class User {
    private int id;
    private String name;
    private String password;
    private String RegisterTime;
    private String role;

    public User() {
    }

    public User(int id, String name, String password, String registerTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.RegisterTime = registerTime;
    }

    // 添加用户
    public User(String name, String password, String registerTime) {
        this.name = name;
        this.password = password;
        this.RegisterTime = registerTime;
    }

    //
    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", RegisterTime='" + RegisterTime + '\'' +
                ", role='" + role + '\'' +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterTime() {
        return RegisterTime;
    }

    public void setRegisterTime(String registerTime) {
        RegisterTime = registerTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
