package com.firstProject.springBootChatApp.server;

public class Message {
	private String name;
	private String message;
	private String channelId;
	private String profileImage;

	public Message() {
	}

	public Message(String name, String message, String channelId, String profileImage) {
		super();
		this.name = name;
		this.message = message;
		this.channelId = channelId;
		this.profileImage = profileImage;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	@Override
	public String toString() {
		return "Message [name=" + name + ", message=" + message + ", channelId=" + channelId + ", profileImage="
				+ profileImage + "]";
	}

}