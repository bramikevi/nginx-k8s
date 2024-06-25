package com.project.springbootpodnginx.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.springbootpodnginx.dto.PostDto;
import com.project.springbootpodnginx.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private MessageSender messageSender;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto post) throws JsonProcessingException {
        PostDto postDto = PostDto.builder()
                .name(post.getName())
                .createdAt(LocalDateTime.now())
                .build();

        messageSender.send(postDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(postDto);
    }

}