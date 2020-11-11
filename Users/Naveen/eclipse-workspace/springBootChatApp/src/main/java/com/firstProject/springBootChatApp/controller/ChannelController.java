package com.firstProject.springBootChatApp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstProject.springBootChatApp.formbeans.Channel;
import com.firstProject.springBootChatApp.service.ChannelService;

@RestController
@RequestMapping("/channels")
public class ChannelController {

	@Autowired
	private ChannelService channelService;

	@GetMapping("/getChannelNames")
	public String getAll() {
		return channelService.getAllChannels();
	}

	@PostMapping("/addChannel")
	public String saveChannel(@RequestBody Channel channel) {
		return channelService.saveChannel(channel);
	}

	@GetMapping("/getChannel/{id}")
	public Optional<Channel> getChannelById(@PathVariable int id) {

		return channelService.getChannelById(id);
	}

	@GetMapping("/getChannelByName/{name}")
	public Optional<Channel> getChannelByName(@PathVariable String name) {
		return channelService.getChannelByName(name);
	}

	@DeleteMapping("/deleteChannel/{id}")
	public String deleteChannelById(@PathVariable("id") int id) {
		return channelService.deleteChannelById(id);
	}
}
