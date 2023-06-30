package com.example.postservice.service.impl;

import com.example.postservice.entities.Post;
import com.example.postservice.repositories.PostRepository;
import com.example.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Post getPostById(int id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElse(null);
    }

    public LocalDateTime getCurrentDate() {
        return LocalDateTime.now();
    }

    @Override
    public Post savePost(Post post) {
        if (isDataIdExists(post.getPostId()))
            return null;

        post.setData(getCurrentDate());
        post.setPostId(generateNumericID(post.getContent()+getCurrentDate().getSecond()));
        return postRepository.save(post);
    }

    public static int generateNumericID(String inputString) {
        int hashCode = inputString.hashCode();
        // Ensure a positive ID value
        return Math.abs(hashCode);
    }


    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    public boolean isDataIdExists(int postID) {
        // Check if data ID exists in the database
        return postRepository.existsById(postID);
    }


    @Override
    public Post updatePostById(int id, Post updatedPost) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            post.get().setTilte(updatedPost.getTilte());
            post.get().setContent(updatedPost.getContent());
            return postRepository.save(post.get());
        } else {
            return null;
        }
    }

    @Override
    public boolean deletePostById(int id) {
        Optional<Post> post = postRepository.findById(id);

        if (post.isPresent()) {
            postRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Post sharePost(Post shared_post) {

        Optional<Post> post = postRepository.findById(shared_post.getPostId());
        if (post.isPresent()) {
            Post newPost=post.get();
            newPost.setOwner(shared_post.getOwner());
            newPost.setPostId(generateNumericID(newPost.getContent()
                    +newPost.getData().getSecond()+newPost.getOwner().getUserName()));
            return postRepository.save(post.get());
        } else {
            return null;
        }
    }
}
