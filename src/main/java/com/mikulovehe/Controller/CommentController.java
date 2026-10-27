package com.mikulovehe.Controller;

import com.mikulovehe.Service.CommentService;
import com.mikulovehe.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public String insertComment(Comment comment) {
        return commentService.insertComment(comment);
    }

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable int id) {
        return commentService.deleteCommentById(id);
    }

    @GetMapping("/{id}")
    public String getAllCommentById(@PathVariable int id) {
        return commentService.findCommentById(id);
    }
}
