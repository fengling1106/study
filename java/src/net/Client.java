package net;

import java.io.*;
import java.net.*;

public class Client {
	public static void Tclient() throws Exception
	{
		Socket socket = new Socket("127.0.0.1",30000);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String line = br.readLine();
		System.out.println("来自Server的消息："+line);
		br.close();
		socket.close();
	}
}
