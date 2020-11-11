package com.firstProject.springBootChatApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstProject.springBootChatApp.formbeans.ChatMessage;
import com.firstProject.springBootChatApp.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping("/getMessages/{id}")
	public String getMessages(@PathVariable String id) {
		return messageService.getMessagesByChannelId(id);
	}

	@PostMapping("/saveMessages")
	public String saveMessages(@RequestBody ChatMessage message) {
		return messageService.saveMessages(message);
	}
}
