package com.firstProject.springBootChatApp.formbeans;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Messages")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ChatMessage{
	public enum MessageType {
		CHAT, JOIN, LEAVE
	}

	private String senderName = null;
	private String message = null;
	private String channelId = null;
	private Date timestamp = new Date();
	private String profileImage = null;
	private MessageType type;

	public ChatMessage(String senderName, String message, String profileImage, String channelId, MessageType type) {
		super();
		this.senderName = senderName;
		this.message = message;
		this.profileImage = profileImage;
		this.channelId = channelId;
		this.type = type;
	}

}
