package com.firstProject.springBootChatApp.server;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

public class Server {
	public static void getSocketConnection() {
		Configuration config = new Configuration();
		config.setHostname("localhost");
		config.setPort(8081);
		final SocketIOServer server = new SocketIOServer(config);
		server.addConnectListener(new ConnectListener() {
			@Override
			public void onConnect(SocketIOClient client) {
				System.out.println("onConnected");
				client.sendEvent("logged", new Message("", "Welcome to the chat!","223","34"));
			}
		});
		server.addDisconnectListener(new DisconnectListener() {
			@Override
			public void onDisconnect(SocketIOClient client) {
				System.out.println("onDisconnected");
			}
		});
		server.addEventListener("message", Message.class, new DataListener<Message>() {

			@Override
			public void onData(SocketIOClient client, Message data, AckRequest ackSender) throws Exception {
				System.out.println("onSend: " + data.toString());
				server.getBroadcastOperations().sendEvent("logged", data);
			}
		});
		System.out.println("Starting server...");
		server.start();
		System.out.println("Server started");
	}
}
