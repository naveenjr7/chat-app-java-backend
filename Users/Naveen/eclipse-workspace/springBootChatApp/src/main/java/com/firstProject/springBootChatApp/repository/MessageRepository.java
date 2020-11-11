package com.firstProject.springBootChatApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.firstProject.springBootChatApp.formbeans.ChatMessage;

@Repository
public interface MessageRepository extends MongoRepository<ChatMessage, String> {
	// @Query(value= "{channelId:?0}")
	List<ChatMessage> findMessagesByChannelId(String id);
}
