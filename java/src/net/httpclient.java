package net;

import net.sf.json.JSONObject;

public class httpclient {
	
	public static void JsonByPost(String url)
	{
		HttpRequest req = new HttpRequest();
		
        JSONObject obj = new JSONObject();  
        obj.put("name", "cwh"); 
        
		String rsp = req.sendPost(url, obj.toString());
		System.out.print("返回结果"+rsp);
	}
	
	public static void getObjForByJsonPost(String url)
	{
		HttpPostTest.HttpPostData(url);
	}	
}
