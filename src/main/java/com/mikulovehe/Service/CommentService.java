package com.mikulovehe.Service;


import com.mikulovehe.pojo.Comment;

public interface CommentService {
    String insertComment(Comment comment);

    String deleteCommentById(int id);

    String findCommentById(int id);
}
