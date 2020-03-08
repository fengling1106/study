package com;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.life.BeanLifeCycle;



public class App 
{
		public static ApplicationContext ctx;
    	public static void main(String[] args) {

    		//ctx = new ClassPathXmlApplicationContext("beans.xml");
    		
    		//System.out.println(ctx);		

    		BeanLifeCycle.LifeCycleInBeanFactory();
    		System.out.println(ctx);
    	}

}
