package com.firstProject.springBootChatApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.firstProject.springBootChatApp.formbeans.Channel;
import com.firstProject.springBootChatApp.formbeans.ChannelWrapper;
import com.firstProject.springBootChatApp.repository.ChannelRepository;
import com.google.gson.Gson;

@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepository;

	public String getAllChannels() {
		List<Channel> channels = this.channelRepository.findAll();
		ChannelWrapper channelList = new ChannelWrapper();
		channelList.setChannels(channels);
		Gson gson = new Gson();
		return gson.toJson(channelList).toString();
	}

	public String saveChannel(Channel channel) {
		this.channelRepository.save(channel);
		return "Added Channel with id " + channel.getChannelId();
	}
	public Optional<Channel> getChannelById(int id) {
		return channelRepository.findById(id);
	}
	public Optional<Channel> getChannelByName(String name) {
		return channelRepository.findByChannelName(name);
	}
	public String deleteChannelById(int id) {
		Channel channel = new Channel();
		channel.setChannelId(id);
		channelRepository.delete(channel);
		return "Deleted Channel with id " + channel.getChannelId();
	}
}
