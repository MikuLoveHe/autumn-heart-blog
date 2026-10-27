package com.mikulovehe.Dao;

import com.mikulovehe.pojo.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class CommentTest {
    @Autowired
    private CommentDao comment;



    @Test
    void insertComment() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = localDate.format(formatter);
        boolean f = comment.insertComment(new Comment("aaaa", formattedDate, 2, 3));
        System.out.println(f);
    }

    @Test
    void updateComment() {
       boolean f = comment.updateComment(new Comment(1,"bbbb"));
        System.out.println(f);
    }

    @Test
    void deleteComment() {
        boolean f= comment.deleteComment(1);
        System.out.println(f);
    }

    @Test
    void selectCommentById() {
        Comment comment1 =comment.selectCommentById(2);
        System.out.println(comment1);
    }

}
