package com.ioc;

public class PersonService {
	private String name;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void info()
	{
		System.out.println("Name is :" +name);
	}

}
