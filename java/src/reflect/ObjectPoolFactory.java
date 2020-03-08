package reflect;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import javax.swing.*;

//通过反射方法创建对象
public class ObjectPoolFactory {

	private Map <String ,Object> objectPool= new HashMap<>();
	Properties config = new Properties();
	
	//创建对象
	private Object createObject(String strClazzName) throws InstantiationException,	IllegalAccessException,ClassNotFoundException
	{
		Class<?> clazz = Class.forName(strClazzName);
		return clazz.newInstance();
	}
	
	//读取配置文件，并创建对象放在map中
	public void initPool(String fileName)throws InstantiationException,	IllegalAccessException,ClassNotFoundException
	{
		try 
		{
			FileInputStream fis = new FileInputStream(fileName);
			
			config.load(fis);
			for (String name:config.stringPropertyNames())
			{
				if (!name.contains("%"))//不包含%的才是类对象
				{
					objectPool.put(name, createObject(config.getProperty(name)));
				}				
			}			
		}
		catch (IOException ex)
		{
			System.out.println("读取"+fileName+"异常");
		}
		
	}
	
	//初始化对象属性
	public void initProperty()throws InvocationTargetException,IllegalAccessException,NoSuchMethodException
	{
		for (String name:config.stringPropertyNames())
		{
			if (name.contains("%"))//包含%的是属性
			{
				String[] objAndProp = name.split("%");
				Object target = getObject(objAndProp[0]); //对象名称
				//获取方法名
				String mtdName="set"+objAndProp[1].substring(0,1).toUpperCase()+objAndProp[1].substring(1);
				//setTitle
				Class<?> targetClass = target.getClass();
				
				Method mtd=targetClass.getMethod(mtdName,String.class);
				
				mtd.invoke(target, config.getProperty(name));
			}
		}
	}
	
	public Object getObject(String name)
	{
		return objectPool.get(name);
	}
	
	/**
	 * @param args
	 */
	public static void UseReflect() throws Exception{
				 
		ObjectPoolFactory pf = new ObjectPoolFactory();
		pf.initPool("obj.txt");
		System.out.println(pf.getObject("a"));
		
		//JFrame cc= (JFrame) pf.getObject("b");
		//cc.setVisible(true);
		
		//利用构造函数创建对象
		/*Class<?> jframeclazz = Class.forName("javax.swing.JFrame");
		Constructor ctor = jframeclazz.getConstructor(String.class);
		Object obj=ctor.newInstance("测试窗口");
		System.out.println(obj);
		JFrame kk= (JFrame) obj;
		kk.setVisible(true);*/
		
		pf.initProperty();
		System.out.println(pf.getObject("b"));
		JFrame mm= (JFrame) pf.getObject("b");
		mm.setVisible(true); //窗口化
	}

}
