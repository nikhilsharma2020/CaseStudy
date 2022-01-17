package com.basha.bean;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

public class Users {

	private String userName;
	private String passWord;
	private String name;
	private long mobileNumber;
	public Users() {

	}
	
	public Users(String userName, String passWord, String name, long mobileNumber) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.name = name;
		this.mobileNumber = mobileNumber;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}


	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}