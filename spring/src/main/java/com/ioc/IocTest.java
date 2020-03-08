package com.ioc;
import com.App;
import org.springframework.context.*;
import org.springframework.context.support.*;

public class IocTest {

	public static void Test() {
		//加载spring bean 配置文件
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		
		//System.out.println(ctx);
		
		//实例化Service类
		PersonService p = App.ctx.getBean("personService",PersonService.class);
		p.info();
		
		//实例化Bean类
		Person p1 = App.ctx.getBean("chinaese",Chinaese.class);
		p1.userAxe();
	}

}
