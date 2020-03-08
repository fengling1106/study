package net;

import java.net.*;

public class InetAddressTest 
 {
	public static void ShowInetAddress()  throws Exception
	{
		InetAddress ip = InetAddress.getByName("www.csdn.net");
		System.out.println(ip.getHostAddress());
		
		InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
		System.out.println(local.getCanonicalHostName());
	}
	
	public static void URLDecoder() throws Exception
	{
		String keyWord = java.net.URLDecoder.decode("%B7%E8%BF%F1", "GBK");
		System.out.println(keyWord);
	}
	
	public static void URLEncoder(String str) throws Exception
	{
		String encoder = java.net.URLEncoder.encode(str,"GBK");
		System.out.println(encoder);
	}
	
	
}
