package com.mikulovehe.Service.Impl;

import com.mikulovehe.Dao.CommentDao;
import com.mikulovehe.Service.CommentService;
import com.mikulovehe.pojo.Comment;
import com.mikulovehe.Util.nowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public String insertComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("评论为空");
        } else if (comment.getContext().trim().isEmpty()) {
            throw new IllegalArgumentException("请输入你的评论");
        }
        comment.setAddTime(nowTime.getTime());
        return commentDao.insertComment(comment) ? "评论成功" : "评论失败";

    }

    @Override
    public String deleteCommentById(int id) {
        return commentDao.deleteComment(id) ? "删除成功" : "删除失败";
    }

    @Override
    public String findCommentById(int id) {
        return commentDao.selectCommentById(id).toString();
    }
}
