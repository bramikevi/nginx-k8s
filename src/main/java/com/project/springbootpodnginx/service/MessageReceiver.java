//package com.project.springbootpodnginx.service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.project.springbootpodnginx.dto.PostDto;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//@Component
//public class MessageReceiver {
//
////    @Autowired
////    private SavedPostEntityRepository repository;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//        @RabbitListener(queues = "REQUEST-QUEUE", messageConverter = "jsonMessageConverter")
//    public void receiveMessage(String jsonMessage) {
//        try {
//            System.out.println("Received message: " + jsonMessage);
//            PostDto postDto = objectMapper.readValue(jsonMessage, PostDto.class);
//            System.out.println("Processed message: " + postDto);
//
////            SavedPostEntity entity = SavedPostEntity.builder()
////                    .createdAt(postDto.getCreatedAt())
////                    .name(postDto.getName())
////                    .savedAt(LocalDateTime.now())
////                    .build();
////
////            repository.save(entity);
//
//
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }
//}