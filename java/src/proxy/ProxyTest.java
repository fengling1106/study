package proxy;

import java.lang.reflect.*;

interface Person
{
	void walk();
	void sayHello(String name);
	
}

class MyInvocationHandler implements InvocationHandler 
{
	public Object invoke(Object proxy,Method method, Object [] args)
	{
		if(args !=null)
		{
			for (Object val: args)
			{
				System.out.println(val);
			}
		}
		else
		{
			System.out.println("方法没有参数");
		}
		
		return null;
		
	}
}

public class ProxyTest {

	public static void UseProxy()
	{
		InvocationHandler handler = new MyInvocationHandler();
		Person p = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[] {Person.class}, handler);
		
		p.walk();
		p.sayHello("fengling");
	}
}
