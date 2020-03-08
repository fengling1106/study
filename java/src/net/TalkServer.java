package net;

import java.io.*;
import java.net.*;
import java.util.*;

public class TalkServer {
	
	public static ArrayList<Socket> socketList= new ArrayList<>();
	
	public static void TServer() throws Exception
	{		
		ServerSocket ss = new ServerSocket(30000);
		
		while(true)
		{
			Socket s = ss.accept();
			socketList.add(s);
			
			new Thread(new ServerThread(s)).start();
			/*PrintStream ps = new PrintStream(s.getOutputStream());
			ps.println("Happy new year!");
			Thread.currentThread().sleep(2000);
			ps.close();
			s.close();*/
		}
	}
}
