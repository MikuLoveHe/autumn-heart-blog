package com.mikulovehe.Dao;

import com.mikulovehe.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;

@Mapper
public interface CommentDao {
    @ResultMap("CommentResultMap")
    boolean insertComment(Comment comment);

    boolean updateComment(Comment comment);

    boolean deleteComment(int id);

    Comment selectCommentById(int id);
}
