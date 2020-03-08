package aop;

//方法性能监控类
public class MethodPerformace {
	private long begin;
	private long end;
	private String serviceMethod;
	
    public MethodPerformace(String serviceMethod){
    	reset(serviceMethod);
    }
    
    //打印执行时间
    public void printPerformace(){
        end = System.currentTimeMillis();
        long elapse = end - begin;
        System.out.println(serviceMethod+"花费"+elapse+"毫秒。");
    }
    
    //设置初始时间
    public void reset(String serviceMethod){
    	this.serviceMethod = serviceMethod;
    	this.begin = System.currentTimeMillis();
    }
}
