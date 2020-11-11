package com.firstProject.springBootChatApp.controller;

import com.firstProject.springBootChatApp.formbeans.ChatMessage;
import com.firstProject.springBootChatApp.service.MessageService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

	@Autowired
	private MessageService messageService;

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		chatMessage.setChannelId("1");
		chatMessage.setTimestamp(new Date());
		messageService.saveMessages(chatMessage);
		return chatMessage;
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSenderName());
		return chatMessage;
	}

}
