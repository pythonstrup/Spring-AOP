package com.bigbell.springdemo;

public class User {
	private String guid;
	private String name;
	private String userId;
	private String pass;
	private String pass2;
	
	public User() {
		
	}
	
	public User(String guid, String name, String userId, String pass, String pass2) {
		super();
		this.guid = guid;
		this.name = name;
		this.userId = userId;
		this.pass = pass;
		this.pass2 = pass2;
	}
	
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPass2() {
		return pass2;
	}
	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
	@Override
	public String toString() {
		return "User [guid=" + guid + ", name=" + name + ", userId=" + userId + ", pass=" + pass + ", pass2=" + pass2
				+ "]";
	}
	
	
}
