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
		 
		 ForumService target = new ForumServiceImpl();//目标对象
		 PerformaceHandler handler = new PerformaceHandler(target);//目标对象初始化编织器
		
		 //使用JDK动态代理方法，参数1：目标对象的类加载器，参数2：目标对象类接口,参数3：编织器实例对象
		 //并实现了目标对象的所有接口，但是怎么实现的呢？
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
