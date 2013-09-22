package com.shurin.DTO;

import java.util.Calendar;

public class UserDTO {
	private Calendar date;
	private String sessionId;
	
	public UserDTO(Calendar date, String sessionId) {
		this.date = date;
		this.sessionId = sessionId;
	}
	
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	public Calendar getDate() {
		return date;
	}
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public String getSessionId() {
		return sessionId;
	}
	

}
