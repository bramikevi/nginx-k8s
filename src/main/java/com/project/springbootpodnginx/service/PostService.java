//package com.project.springbootpodnginx.service;
//
//import com.project.springbootpodnginx.entity.PostEntity;
//import com.project.springbootpodnginx.repo.PostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class PostService {
//
//    @Autowired
//    private PostRepository postRepository;
//
//    public Iterable<PostEntity> getAllPosts() {
//        return postRepository.findAll();
//    }
//
//    public PostEntity savePost(PostEntity post) {
//        return postRepository.save(post);
//    }
//
//    public Optional<PostEntity> getPostById(String id) {
//        return postRepository.findById(id);
//    }
//
//    public void deletePostById(String id) {
//        postRepository.deleteById(id);
//    }
//}