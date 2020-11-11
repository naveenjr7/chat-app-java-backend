
package com.firstProject.springBootChatApp.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.firstProject.springBootChatApp.formbeans.ChatMessage;
import com.firstProject.springBootChatApp.repository.MessageRepository;

public class MessageComponent implements CommandLineRunner {
	@Autowired
	private MessageRepository messageRepository;

	@Override
	public void run(String... args) throws Exception {
		ChatMessage message = new ChatMessage("Raj MOHAN", "hI Da", "23dasdt3r3434sdszczds", "25",
				ChatMessage.MessageType.CHAT);
		this.messageRepository.save(message);
	}

}
