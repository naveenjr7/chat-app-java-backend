package com.firstProject.springBootChatApp.server;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.firstProject.springBootChatApp.formbeans.Channel;

public class Server {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.setHostname("localhost");
		config.setPort(3700);
		final SocketIOServer server = new SocketIOServer(config);
		server.addConnectListener(new ConnectListener() {
			@Override
			public void onConnect(SocketIOClient client) {
				System.out.println("onConnected");
				client.sendEvent("message", new Channel("One", 34, "Welcome to the chat!"));
			}
		});
		server.addDisconnectListener(new DisconnectListener() {
			@Override
			public void onDisconnect(SocketIOClient client) {
				System.out.println("onDisconnected");
			}
		});
		server.addEventListener("send", Channel.class, new DataListener<Channel>() {

			@Override
			public void onData(SocketIOClient client, Channel data, AckRequest ackSender) throws Exception {
				System.out.println("onSend: " + data.toString());
				server.getBroadcastOperations().sendEvent("message", data);
			}
		});
		System.out.println("Starting server...");
		server.start();
		System.out.println("Server started");

	}
}
