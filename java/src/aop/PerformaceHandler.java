package aop;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//性能回调处理器
public class PerformaceHandler implements InvocationHandler {
    private Object target;
    
    //设置调用目标对象
	public PerformaceHandler(Object target){
		this.target = target;
	}
	
	//调用目标的方法
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		PerformanceMonitor.begin(target.getClass().getName()+"."+ method.getName());
		
		Object obj = method.invoke(target, args);
		
		PerformanceMonitor.end();
		
		return obj;
	}
}
