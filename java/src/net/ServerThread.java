package net;

import java.io.*;
import java.net.*;

public class ServerThread implements Runnable{
	
	Socket s = null;
	BufferedReader br = null;
	
	public ServerThread(Socket s) throws Exception{
		this.s =s ;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	
	public void run()
	{
		try{
			String content =null;
			while((content = readClient())!=null ){
				for (Socket s:TalkServer.socketList){
					PrintStream ps = new PrintStream(s.getOutputStream());
					ps.println(content);
					System.out.println("Server Receive Info:"+content);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String readClient()
	{
		try{
			return br.readLine();
		}
		catch(Exception e){
			TalkServer.socketList.remove(s);
		}
		return null;
	}
		
}
