package com.shurin.utils;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.shurin.DAO.UserDao;
import com.shurin.DTO.UserDTO;

public final class Utils {
	public static boolean isIdSessionUsed(UserDao userDao, HttpSession session) {
		Map<String, UserDTO> users = userDao.getUsers();
		Set<String> keys = users.keySet();
		for (String key : keys) {
			if (session.getId().equals(users.get(key).getSessionId())) {
				return true;
			}
		}
		return false;
	}

}
