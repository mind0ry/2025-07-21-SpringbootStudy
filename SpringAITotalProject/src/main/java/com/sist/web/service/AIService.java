package com.sist.web.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIService {

	private final ChatClient chatClient;
	
	public AIService(ChatClient.Builder chatClientBuilder) {
		this.chatClient=chatClientBuilder.build();
	}
	
	public String aiChat(String userMessage) {
		String s=chatClient.prompt()
				.user(userMessage+" 여행지 추천 명칭만")
				.call()
				.content();
		return s;
	}
}
