package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DealFile {
	
	//列出目录下所有文件名
	public static List<File> getFilebyPath(String srcDirPath)
	{
		
		File srcDir = new File(srcDirPath);
		if(!srcDir.exists())
		{
			System.out.println("目录不存在");
			return null;
		};
		
		File[] file = new File[] {};
		List<File> list = new ArrayList<File>();
		
		if (srcDir.isDirectory()) {			
			file = srcDir.listFiles();
			int len = file.length;
			for (int i = 0; i < len; i++) {
				list.add(file[i]);
				System.out.println(file[i].getName());
			}
		}
		
		return list;
	}
	
	//修改文件名（路径）
	public static void modifyFileName(String srcPath, String srcFileName,  String destPath, String destFileName)
	{
		/*for (int i=0; i<oldFile.size();i++)
		{
			File file = oldFile.get(i);
			file.renameTo(new File(srcPath+"/"+"123"));
		}*/
		File srcfile = new File("srcPath"+"/"+srcFileName);
		srcfile.renameTo(new File(destPath+"/"+destFileName));
		
		//return getFilebyPath(srcPath);
	}
	
	
	//按行读取文件内容
	public static void readFile(String fileName) throws IOException
	{
		try{
			FileReader fr = new FileReader(fileName);
			
			char[] buf = new char[256];
			
			int hasRead = 0;
			
			while((hasRead = fr.read(buf))>0)
			{
				System.out.println(new String(buf,0,hasRead));
			}
			fr.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	//写入文件
	public static void  writeFile(String destFileName,String strData) throws IOException{
		
		try
		{
			FileWriter fw = new FileWriter(destFileName);
			fw.write(strData);
			
			fw.close();
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	//插入文件内容
	public static void inserFile(String destFileName, String strInsertData) throws IOException{
		
		//StringBuffer strBuf = new StringBuffer();
		File tmp = File.createTempFile("tmp", null);
		try
		{
			RandomAccessFile raf = new RandomAccessFile(destFileName,"rw");
			FileOutputStream tmpOut = new FileOutputStream(tmp);
			FileInputStream tmpIn = new FileInputStream(tmp);
			
			raf.seek(7);
			
			byte [] bbuf = new byte[32];
			
			int hasRead = 0;
			
			
			while ((hasRead = raf.read(bbuf))>0)
			{
				tmpOut.write(bbuf, 0, hasRead);
			}
			
			raf.seek(7);
			
			raf.write(strInsertData.getBytes());
			
			while((hasRead = tmpIn.read(bbuf))>0)
			{
				raf.write(bbuf,0,hasRead);
			}
			
			
			raf.close();
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void ShowFile() throws IOException 
	{
		FilePropery test = new FilePropery();
		
		test.ShowFile();	
		
	}
	
	//String练习
	 public static void StringTest()
	 {
		String str1 = "a12345";
		String str2 = "b12345";
		
		StringBuffer sb = new StringBuffer();
		sb.append(str1);
		sb.append(str2);
		System.out.println(sb.toString());
		
		StringBuilder sb2 = new StringBuilder ();
		sb2.append(sb.toString()+"www");
		System.out.println(sb2.toString());	 
	 }
	 
	 //时间格式化联系
	 public static void dateformat()
	 {
		 Calendar cal = Calendar.getInstance();
		 Date time = cal.getTime();
		 System.out.println(time);
		 
		 SimpleDateFormat sdf = new SimpleDateFormat();
		 sdf.applyPattern("yyyy-MM-dd H:m:s");
		 
		 System.out.println(sdf.format(time));;
		  
	 }
}
