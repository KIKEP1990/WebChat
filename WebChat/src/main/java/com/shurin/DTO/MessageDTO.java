package com.shurin.DTO;

import java.util.Calendar;

public class MessageDTO {
	private String message;
	private Calendar date;
	
	public MessageDTO(String message, Calendar date) {
		this.date = date;
		this.message = message;
	}
	
	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
