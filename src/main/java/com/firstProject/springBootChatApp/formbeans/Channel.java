package com.firstProject.springBootChatApp.formbeans;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Channels")
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

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
