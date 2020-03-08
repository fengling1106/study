package net;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author fengling
 * @create 2017-11-23
 * @Description 定义用户信息基础模型
 */
public class User implements Serializable {


	private static final long serialVersionUID = 300002017060101L;
	private String userName;
	private String userPasswd;
	private String email;
	private int state;
	private Timestamp createDate;
	private Timestamp modifyDate;
	

	public String getUserName()
	{	
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName =userName;
	}	
	
	public String getUserPasswd()
	{
		return userPasswd;
	}
	public void setUserPasswd(String userPasswd)
	{
		this.userPasswd=userPasswd ;
	}	
	
	public void setEmail(String email)	
	{
		this.email =  email;
	}
	public String getEmail()
	{
		return this.email;
	}	
	
	public void setState(int state)	
	{
		this.state =  state;
	}
	public int getState()
	{
		return this.state;
	}
	
	public void setCreateDate(Timestamp createDate)
	{
		this.createDate =  createDate;
	}
	public Timestamp getCreateDate()
	{
		return this.createDate;
	}

	public void setModifyDate(Timestamp modifyDate)
	{
		this.modifyDate =  modifyDate;
	}
	public Timestamp getModifyDate()
	{
		return this.modifyDate;
	}
	
}
