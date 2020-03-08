package net;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class HttpPostTest {

    public static void HttpPostData(String url) {    
        try {   
            HttpClient httpclient = new DefaultHttpClient();    
            String uri = url;   
            HttpPost httppost = new HttpPost(uri);     
            //添加http头信息   
            httppost.addHeader("Authorization", "your token"); //认证token   
            httppost.addHeader("Content-Type", "application/json");   
            httppost.addHeader("User-Agent", "imgfornote");    
            JSONObject obj = new JSONObject();  
            obj.put("name", "cwh");   
            httppost.setEntity(new StringEntity(obj.toString())); 
            
            HttpResponse response;    
            response = httpclient.execute(httppost);    
            //检验状态码，如果成功接收数据    
            int code = response.getStatusLine().getStatusCode();    
            System.out.println(code+"code");  
            if (code == 200) {    
                String rev = EntityUtils.toString(response.getEntity());//返回json格式： {"id": "","name": ""}           
                obj= JSONObject.fromObject(rev);  
                System.out.println("返回数据==="+obj.toString());  
                User user = (User)JSONObject.toBean(obj,User.class);  
                System.out.println("返回数据==="+user.toString());  
                System.out.println("返回数据==="+user.getUserName());
            }   
            } catch (ClientProtocolException e) {   
                e.printStackTrace();  
            } catch (IOException e) {    
                e.printStackTrace();  
            } catch (Exception e) {   
                e.printStackTrace();  
            }   
       }  
}
