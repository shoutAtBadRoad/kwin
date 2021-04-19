package com.kwin.db.test.user.entity;

import java.io.Serializable;

public class Admin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 266085250803725298L;
	private int adminId;
	private String userName;
	private String password;
	private String name;
	private String tel;

	
	
	public Admin(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}


	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
