package aop;

//执行监控类
public class PerformanceMonitor {
	
	//定义线程变量
	private static ThreadLocal<MethodPerformace> performaceRecord = new ThreadLocal<MethodPerformace>();
	
	public static void begin(String method) {
		System.out.println("begin monitor...");
		//该变量保存一个在本线程中的执行时间
		MethodPerformace mp = performaceRecord.get();
		if(mp == null){
			//该方法设置一个线程本地变量
			mp = new MethodPerformace(method);//记录初始时间
			performaceRecord.set(mp);
		}else{
		    mp.reset(method);	
		}
	}
	
	public static void end() {
		System.out.println("end monitor...");
		MethodPerformace mp = performaceRecord.get();
		mp.printPerformace();
	}
}
