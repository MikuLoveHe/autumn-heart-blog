package com.mikulovehe.Util;

import com.mikulovehe.pojo.User;

public class tofUser {
    public static void tofUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("用户为空");
        }
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("用户名为空");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("密码为空");
        }
        if (user.getName().length() > 35) {
            throw new IllegalArgumentException("用户名最长为35位字符");
        }
        if (user.getPassword().length() > 40) {
            throw new IllegalArgumentException("密码最长为40位字符");
        }
    }
}
