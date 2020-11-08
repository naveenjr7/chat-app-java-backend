package com.firstProject.springBootChatApp.persistance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.firstProject.springBootChatApp.formbeans.Channel;
import com.firstProject.springBootChatApp.repository.ChannelRepository;

@Component
public class ChannelPersistance implements CommandLineRunner {

	private ChannelRepository channelRepository;

	public ChannelPersistance(ChannelRepository channelRepository) {
		this.channelRepository = channelRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Channel channel = new Channel("ChannelOne", 22, "On Topic");
		this.channelRepository.save(channel);
	}
	

}
