package com.example.postservice.service;

import com.example.postservice.entities.Post;

import java.util.List;

public interface PostService {

    public Post getPostById(int id);

    public Post savePost(Post post);

    public List<Post> getAllPosts();

    public Post updatePostById(int id, Post updatedPost);

    public Post sharePost(Post shared_post);

    public boolean deletePostById(int id);

}
