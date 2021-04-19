package com.kwin.db.test.user.entity;

import java.io.Serializable;

public class Visitor  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3995327662802355576L;
	private int visitorId;
	private int visitorNumber;
	private String userName;
	private String password;
	private int companyId = 0;
	private String name;
	private String tel;
	
	public Visitor() {
	}
	
	public Visitor(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	
	public Visitor(int visitorNumber, String userName,String password, int companyId,
			 String name, String tel) {
		this.visitorNumber = visitorNumber;
		this.userName = userName;
		this.password = password;
		this.companyId = companyId;
		this.name = name;
		this.tel = tel;
	}

	public int getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getVisitorNumber() {
		return visitorNumber;
	}
	public void setVisitorNumber(int visitorNumber) {
		this.visitorNumber = visitorNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
