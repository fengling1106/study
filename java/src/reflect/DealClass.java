package reflect;

import java.lang.annotation.*;
import java.lang.reflect.*;

import obj.Apple;

public class DealClass {
	
	public static void ShowClassProperty()
	{
		Class<Apple> clazz = Apple.class;
		
		Constructor [] ctors = clazz.getConstructors();

		System.out.println("获取所有构造函数");		
		for(Constructor ct:ctors)
		{
			System.out.println(ct);
		}
		
		System.out.println("获取所有方法");		
		Method [] mthds = clazz.getMethods();		
		for(Method mt : mthds)
		{
			System.out.println(mt);
						
			Annotation [] ants = mt.getAnnotations();
			for(Annotation at : ants)
			{
				System.out.println("注解："+at);
			}
			
		}
		
		System.out.println("类对象的注解");
		Annotation [] anns = clazz.getAnnotations();
		for(Annotation an : anns)
		{
			System.out.println("类对象的注解："+an);
		}

		
		
	}
	
}
