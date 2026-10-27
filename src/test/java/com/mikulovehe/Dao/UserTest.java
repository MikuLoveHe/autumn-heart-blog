package com.mikulovehe.Dao;

import com.mikulovehe.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserDao userDao;

    @Test
    void insertUserTest() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowDate = localDate.format(formatter);
        boolean f = userDao.insertUser(new User("111", "123456", nowDate));
        System.out.println(f);
    }

    @Test
    void updateUserTest() {
        boolean f = userDao.updateUser(new User(9, "222", "22"));
        System.out.println(f);
    }

    @Test
    void deleteUserTest() {
        boolean f =userDao.deleteUserById(1);
        System.out.println(f);
    }
}
