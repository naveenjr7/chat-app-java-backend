package com.firstProject.springBootChatApp.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.firstProject.springBootChatApp.formbeans.Channel;
import com.firstProject.springBootChatApp.repository.ChannelRepository;

public class ChannelComponent implements CommandLineRunner {

	@Autowired
	private ChannelRepository channelRepository;

	@Override
	public void run(String... args) throws Exception {
		Channel channel = new Channel("Channel35", 23, "On Topic");
		this.channelRepository.save(channel);
	}

}
