package com.shurin.DAO;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.shurin.DTO.MessageDTO;
import com.shurin.DTO.UserDTO;

public class Repository {
	private static Repository instance;
	private Map<String, UserDTO> users;
	private List<MessageDTO> message;

	private Repository() {
		users = new ConcurrentHashMap<String, UserDTO>();
		message = Collections.synchronizedList(new LinkedList<MessageDTO>());
	}

	public static Repository getInstance() {
		if (instance == null) {
			instance = new Repository();
		}
		return instance;
	}

	public Map<String, UserDTO> getUsersList() {
		return users;
	}

	public void addUser(String name, UserDTO date) {
		users.put(name, date);
	}

	public List<MessageDTO> getMessageList() {
		return message;
	}

	public void setMessage(MessageDTO message) {
		this.message.add(message);
	}

}
