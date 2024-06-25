//package com.project.springbootpodnginx.service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.project.springbootpodnginx.dto.PostDto;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.core.MessageListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RabbitMQListner implements MessageListener {
//
//	private final ObjectMapper objectMapper;
//
//	public RabbitMQListner(ObjectMapper objectMapper) {
//		this.objectMapper = objectMapper;
//	}
//
//	@Override
//	public void onMessage(Message message) {
//		try {
//			String messageBody = new String(message.getBody());
//			System.out.println("Consuming Message - " + messageBody);
//
//			PostDto postDto = objectMapper.readValue(messageBody, PostDto.class);
//			System.out.println("Converted PostDto - " + postDto);
//
//			// tutaj możesz dodać dalsze przetwarzanie obiektu postDto
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}