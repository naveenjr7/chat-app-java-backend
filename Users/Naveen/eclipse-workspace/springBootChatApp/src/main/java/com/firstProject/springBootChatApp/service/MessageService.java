package com.firstProject.springBootChatApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.firstProject.springBootChatApp.formbeans.MessageWrapper;
import com.firstProject.springBootChatApp.formbeans.ChatMessage;
import com.firstProject.springBootChatApp.repository.MessageRepository;
import com.google.gson.Gson;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	public String getMessagesByChannelId(String id) {
		List<ChatMessage> messages = this.messageRepository.findMessagesByChannelId(id);
		MessageWrapper wrapper = new MessageWrapper();
		wrapper.setMessages(messages);
		return new Gson().toJson(wrapper).toString();
	}

	public String saveMessages(@RequestBody ChatMessage message) {
		this.messageRepository.save(message);
		return "Message " + message.getMessage() + " has been saved";
	}
}
