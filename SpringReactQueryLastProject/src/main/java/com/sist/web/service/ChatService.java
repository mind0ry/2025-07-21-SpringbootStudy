package com.sist.web.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class ChatService {
   private final ChatClient chatClient;
   
   public ChatService(ChatClient.Builder chatClientBuilder)
   {
	   this.chatClient=chatClientBuilder.build();
   }
   
   public Flux<String> streamChat(String userMessage)
   {
	   Flux<String> f=chatClient.prompt()
			         .user(userMessage)
			         .stream()
			         .content()
			         .doOnNext(System.out::println); // ai가 보낸준 데이터 출력 
	   return f;
   }
}