package com.valen.domain;

public class User {

	private String userName;
	private String passWord;
	private int userId;
	
	public String getUserName()
	{
		
		return userName;
	}
	public void setUserName(String userName)
	{
		 this.userName =userName;
	}	
	
	public String getPassWord()
	{
		
		return passWord;
	}
	public void setPassWord(String passWord)
	{
		 this.passWord=passWord ;
	}	
	
	public void setUserId(int userId)
	{
		this.userId = userId;
		this.userId = 123456;
	}
	
	public int getUserId()
	{
		return userId;
	}
}
