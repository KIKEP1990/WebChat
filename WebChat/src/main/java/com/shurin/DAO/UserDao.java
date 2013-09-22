package com.shurin.DAO;

import java.util.List;
import java.util.Map;

import com.shurin.DTO.MessageDTO;
import com.shurin.DTO.UserDTO;

public class UserDao {
	private Repository repository;

	public UserDao() {
		repository = Repository.getInstance();
	}

	public Map<String, UserDTO> getUsers() {
		return repository.getUsersList();
	}

	public void addUser(String name, UserDTO date) {
		repository.addUser(name, date);
	}
	
	public void addMessage(MessageDTO message) {
		repository.setMessage(message);
	}
	
	public List<MessageDTO> getMessageList() {
		return repository.getMessageList();
	}
}
