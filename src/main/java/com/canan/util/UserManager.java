package com.canan.util;

public class UserManager {
	
	String userName = "admin";
	String userPass = "qwerty";
	String userEmail = "admin@admin.com";
	public int authority = 1;
	
	public UserManager(String userName, String userPass, String userEmail, int authority) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.userEmail = userEmail;
		this.authority = authority;
		
	}
	
	public UserManager() {
		super();
	}
	
	@Override
	public String toString() {
		return "UserManager [userName=" + userName + ", userPass=" + userPass + ", userEmail=" + userEmail
				+ ", authority=" + authority + "]";
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPass() {
		return userPass;
	}
	
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public int getAuthority() {
		return authority;
	}
	
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
}