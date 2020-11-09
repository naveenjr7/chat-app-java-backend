package com.firstProject.springBootChatApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstProject.springBootChatApp.formbeans.Channel;
import com.firstProject.springBootChatApp.repository.ChannelRepository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@RestController
@RequestMapping("/channels")
public class ChannelController {
	private ChannelRepository channelRepository;

	public ChannelController(ChannelRepository channelRepository) {
		this.channelRepository = channelRepository;
	}

	@GetMapping("/getAll")
	public List<Channel> getAll() {
		return this.channelRepository.findAll();
	}

	@PostMapping("/addChannel")
	public String saveChannel(@RequestBody Channel channel) {
		this.channelRepository.save(channel);
		return "Added Channel with id " + channel.getChannelId();
	}

	@GetMapping("/getChannel/{id}")
	public Optional<Channel> getChannelById(@PathVariable int id) {

		return channelRepository.findById(id);
	}

	@GetMapping("/getChannelByName/{name}")
	public Optional<Channel> getChannelByName(@PathVariable String name) {

		return channelRepository.findByChannelName(name);
	}

	@DeleteMapping("/deleteChannel/{id}")
	public String getChannelById1(@PathVariable("id") int id) {
		Channel channel = new Channel();
		channel.setChannelId(id);
		channelRepository.delete(channel);
		return "Deleted Channel with id " + channel.getChannelId();
	}
}
