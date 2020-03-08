package log;

import org.apache.commons.logging.*;

public class WrapLog {

	private static Log log = LogFactory.getLog(WrapLog.class);

	public static void printLog()
    {
        System.out.println( "Hello World!" ); //输出到控制台    
        
        // 记录debug级别的信息  
        //logger.debug("This is debug message.");  
        // 记录info级别的信息  
        //logger.info("This is info message.");  
        // 记录error级别的信息  
        //logger.error("This is error message.");  
        log.error("ERROR:这是error级别错误");
        log.debug("DEBUG：this dubug");
        log.warn("WARN：this warn");
        log.info("INFO：this info");
        log.trace("TRACE: this trace");
        System.out.println(log.getClass());  //输出到控制台    
    }
	
}
