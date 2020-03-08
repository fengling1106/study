
import java.io.*;

import org.apache.log4j.*;

import algorithm.bintree.BinSortTree;
import algorithm.sort.Sort;
import aop.TestForumService;
import db.DBApp;
import dsp.ObserverTest;
import file.DealFile;
import list.DealList;
import load.BootLoader;
import load.CompileClassLoader;
import log.WrapLog;
import net.Client;
import net.TalkServer;
import net.httpclient;
import reflect.DealClass;
import reflect.FieldTest;
import reflect.ObjectPoolFactory;
import system.DealSystem;
import thread.DealRunnable;
import thread.DealThread;

public class study {

	public static void main(String[] args) throws Exception{
	
		PropertyConfigurator.configure("config/log4j.properties");
		
		//参数设计
		/*if( 0 == args.length)
		{
			System.out.println("请输入合法的参数");
			return;
		}*/
		
		 //获取目录下文件名
		//List<File> lfile = getFilebyPath("E:/test");
		//modifyFileName("E:/test",lfile);
		//modifyFileName("E:/test",lfile.get(0).getAbsolutePath(),"E:/test","www");
		//readFile("E:/test/abc.txt");
		
		//writeFile("E:/test/new001.txt", "我爱祖国天安门");
		
		//inserFile("E:/test/new001.txt", "0123456789");
			
		//StringTest();
		//dateformat();
		
		//DealSystem.printCurrentSystem();
		
		//DealList.UseIterator();
		//DealThread.StartThread();
		//DealRunnable.StartRunnable();
		
		//ObjectPoolFactory.UseReflect();
		//DealFile.ShowFile();
		
		//ObserverTest.UseObserver();
		//DBApp.UseDB();
		
		//BootLoader.ShowBootstrap();
		
		//String [] argaa = new String []{"java","CompileClassLoader","Hello"};
		//CompileClassLoader.UseDynamicCompile(new String []{"java","CompileClassLoader","Hello"});
		//DealClass.ShowClassProperty();
		
		//FieldTest.UseField();
		TestForumService.UseAOP(args);
		
		//TalkServer.TServer();
		//Thread.currentThread().sleep(2);
		//Client.Tclient();
		
		//httpclient.getObjForByJsonPost("http://localhost:8080/future/query/UserInfo.html");
		//httpclient.JsonByPost("http://localhost:8080/future/query/UserInfo.html");
		//WrapLog.printLog();
		
		//Sort.InsertSort();
		
		
		/*BinSortTree bstree = new BinSortTree(10);
		bstree.insert(9);
		bstree.insert(5);
		bstree.insert(6);
		bstree.insert(8);
		bstree.inOrderTraverse();
		bstree.preOrderTraverse();
		bstree.postOrderTraverse();*/
		
		
	}
	

}
