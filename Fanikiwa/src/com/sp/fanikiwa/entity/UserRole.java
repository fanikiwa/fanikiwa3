package com.sp.fanikiwa.entity;

public abstract class UserRole {

	private String userId;
	private String role;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
 
}
