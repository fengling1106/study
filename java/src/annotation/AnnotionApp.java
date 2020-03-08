package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import annotation.SayHiAnnotation;
import annotation.SayHiEmlement;

public class AnnotionApp {

	public static void UseApp() throws IllegalAccessException,
	IllegalArgumentException,InvocationTargetException,ClassNotFoundException
	{
		SayHiEmlement element = new SayHiEmlement();
		Method [] methods = SayHiEmlement.class.getDeclaredMethods(); // 获得所有方法
		for (Method method : methods)
		{
			SayHiAnnotation  annotationTmp = null;
			// 检测是否使用了我们的注解
			if ((annotationTmp = method.getAnnotation(SayHiAnnotation.class))!=null)
			{
				// 如果使用了我们的注解，我们就把注解里的"paramValue"参数值作为方法参数来调用方法
				
				method.invoke(element, annotationTmp.paramValue());
			}
			else
			{
				// 如果没有使用我们的注解，我们就需要使用普通的方式来调用方法了
				method.invoke(element, "baobao"); 
			}
		}
	}

}
