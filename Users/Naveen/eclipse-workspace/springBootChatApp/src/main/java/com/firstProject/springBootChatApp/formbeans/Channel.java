package com.firstProject.springBootChatApp.formbeans;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Channels")
@Getter
@Setter
@AllArgsConstructor
@ToString 
public class Channel {
	private String channelName = null;
	@Id
	private int channelId = 0;
	private Date createdDate = new Date();
	private String description = null;

	public Channel(String channelName, int channelId, String description) {
		this.channelName = channelName;
		this.channelId = channelId;
		this.description = description;
	}

	public Channel() {
		// TODO Auto-generated constructor stub
	}


}
