package aop;
import java.lang.reflect.Proxy;

//测试论坛服务类
public class TestForumService {
	public static void UseAOP(String[] args) {
		 //一般的业务类正常编码的测试
		 System.out.println("普通的类方法执行测试");
		 ForumService forumService = new ForumServiceImpl();
		 forumService.removeForum(10);
		 forumService.removeTopic(1012);
		
		 System.out.println("\r\n");	
		System.out.println("使用JDK动态代理执行测试"); 
		 // 使用JDK动态代理
		ForumService target = new ForumServiceImpl();
		PerformaceHandler handler = new PerformaceHandler(target);
		ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);
		proxy.removeForum(10);
		proxy.removeTopic(1012);
			
			//使用CGLib动态代理
			/*CglibProxy proxy = new CglibProxy();
			ForumService forumService = (ForumService)proxy.getProxy(ForumServiceImpl.class);
			forumService.removeForum(10);
			forumService.removeTopic(1023);*/
			
	}
}
