package com.kwin.db.test.user.entity;

import java.io.Serializable;

public class SystemManager  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6464408411373118599L;
	private int systemManagerId;
	private String userName;
	private String password;
	private int companyId;
	private String companyName;
	private String name;
	private String tel;
	
	public SystemManager() {

	}
	
	public SystemManager(String userName, String password, 
			String name, String tel) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.tel = tel;
	}



	public SystemManager(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}


	public int getSystemManagerId() {
		return systemManagerId;
	}
	public void setSystemManagerId(int systemManagerId) {
		this.systemManagerId = systemManagerId;
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
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int CompanyId) {
		this.companyId = CompanyId;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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