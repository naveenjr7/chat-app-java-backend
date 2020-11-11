package com.firstProject.springBootChatApp.formbeans;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageWrapper {
	private List<ChatMessage> messages = null;

}
