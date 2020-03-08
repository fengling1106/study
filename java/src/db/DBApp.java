package db;

import java.sql.*;
import java.lang.reflect.*;

public class DBApp {

	public static void UseDB() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		//执行方式：java -classpath %CLASSPATH%;./lib/* ConnMySql
		try
		{
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/future","root","valen");
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select t.user_name,t.email from tb_user t");
			
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
