package com.firstProject.springBootChatApp.formbeans;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChannelWrapper {
	private List<Channel> channels = null;

}
