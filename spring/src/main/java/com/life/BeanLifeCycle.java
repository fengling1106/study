package com.life;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.life.Car;

public class BeanLifeCycle {
    public static void LifeCycleInBeanFactory(){

       //①下面两句装载配置文件并启动容器
 	   Resource res = new ClassPathResource("beans.xml");
 	 
       BeanFactory bf= new DefaultListableBeanFactory();
       XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory)bf);
       reader.loadBeanDefinitions(res);

       //②向容器中注册MyBeanPostProcessor后处理器
       ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());

       //③向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
       ((ConfigurableBeanFactory)bf).addBeanPostProcessor(
               new MyInstantiationAwareBeanPostProcessor());
       //④第一次从容器中获取car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用。
       System.out.println("第1辆小汽车");
       Car car1 = (Car)bf.getBean("car");

       car1.introduce();
       car1.setColor("红色");
       System.out.println("----------------------------------------\r\n");
       //⑤第二次从容器中获取car，直接从缓存池中获取
       System.out.println("第2辆小汽车");
       Car car2 = (Car)bf.getBean("car");
       car2.hashCode();
       System.out.println("第1辆和第2辆一样吗？");
       //⑥查看car1和car2是否指向同一引用
       System.out.println("car1==car2:"+(car1==car2));
       System.out.println("car1="+car1.hashCode());
       System.out.println("car2="+car2.hashCode());
       //⑦关闭容器
       ((DefaultListableBeanFactory)bf).destroySingletons();
       System.out.println("----------------------------------------\r\n");
    }
}
