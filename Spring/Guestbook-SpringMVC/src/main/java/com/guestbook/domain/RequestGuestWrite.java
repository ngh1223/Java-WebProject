package com.guestbook.domain;

public class RequestGuestWrite {
	private String guestName;
	private String password;
	private String message;
	
	
	public RequestGuestWrite() {}

	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Message toMessage() {
		Message message = new Message(0,guestName, password, this.message);
		return message;
	}
	
}

