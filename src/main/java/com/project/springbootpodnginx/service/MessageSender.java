package com.project.springbootpodnginx.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.springbootpodnginx.dto.PostDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    public static final String queueName = "REQUEST-QUEUE";

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @Autowired
    private ObjectMapper objectMapper;

//    public void send(PostDto messageDto) {
//        try {
//            String jsonMessage = objectMapper.writeValueAsString(messageDto);
//            rabbitTemplate.convertAndSend(queueName, jsonMessage);
//            System.out.println("Message sent to queue: " + jsonMessage);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }

    public void send(PostDto messageDto) throws JsonProcessingException {
        String jsonMessage = objectMapper.writeValueAsString(messageDto);
        template.convertAndSend(queue.getName(), jsonMessage);
        System.out.println("Send msg = " + messageDto);

    }
}