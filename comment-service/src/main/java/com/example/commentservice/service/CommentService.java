package com.example.commentservice.service;

import com.example.commentservice.entities.Comment;
import java.util.List;
public interface CommentService {

    Comment createComment(Comment comment);
    List<Comment> getAllComments();
    Comment getCommentById(String id);
    Comment updateComment(String id, Comment comment);
    void deleteComment(String id);
    List<Comment> getCommentsByPostId(String postId);
    int getNumberOfLikesByCommentId(String commentId);
    int getNumberOfLovesByCommentId(String commentId);
    int getNumberOfAngryByCommentId(String commentId);
}
