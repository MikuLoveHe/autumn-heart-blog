package com.mikulovehe.Dao;

import com.mikulovehe.pojo.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class TagTest {

    @Autowired
    private TagDao tagDao;

    /*@Test
    void insertTag() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = localDate.format(formatter);
        boolean f = tagDao.insertTag(new Tag("风景", formattedDate)) > 0;
        System.out.println("insertTag: " + f);
    }*/


    /*@Test
    void updateTag() {
        boolean f = tagDao.updateTag(new Tag(1, "bbbb"));
        System.out.println("updateTag: " + f);
    }*/

    @Test
    void selectTagById() {
        Tag tag = tagDao.selectTagById(1);
        System.out.println("selectTagById: " + tag);
    }

    @Test
    void deleteTag() {
        boolean f = tagDao.deleteTag(1);
        System.out.println("deleteTag: " + f);
    }
}
