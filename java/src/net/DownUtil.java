package net;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownUtil {
	private String path;
	private String targetFile;
	private int threadNum;
	private DownThread[] threads;
	private int fileSize;
	
	public DownUtil(String path, String targetFile, int threadNum)
	{
		this.path = path;
		this.threadNum = threadNum;
		
		threads = new DownThread[threadNum];
		this.targetFile = targetFile;
	}
	
	public void downLoad() throws Exception
	{
		
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5*1000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accetp", "image/gif,image/jepg,image/pjepg,application/xaml+xml");
		conn.setRequestProperty("Accept-language", "zh-CN");
		conn.setRequestProperty("Charset","UTF-8");
		conn.setRequestProperty("Connection", "Keep-alive");
		
		fileSize = conn.getContentLength();
		conn.disconnect();
		
		//计算每份文件的大小
		int currentPartSize = fileSize/threadNum + 1;
		
		RandomAccessFile file = new RandomAccessFile(targetFile,"rw");
		file.setLength(fileSize);
		file.close();
		
		for(int i=0; i<threadNum; i++)
		{
			//每份文件下载起点位置
			int startPos = i*currentPartSize;
			RandomAccessFile currentPart = new RandomAccessFile(targetFile,"rw");
			currentPart.seek(startPos);
			threads[i] = new DownThread(startPos,currentPartSize,currentPart);
			threads[i].start();
		}
		
	}
	
	public double getCompleteRate()
	{
		int sumSize = 0;
		for (int i=0; i<threadNum; i++)
		{
			sumSize += threads[i].length;
			
		}
		
		return sumSize*1.0/fileSize;
	}
	
	private class DownThread extends Thread
	{
		private int startPos;
		private int currentPartSize;
		
		private RandomAccessFile currentPart;
		public int length;
		
		public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart)
		{
			this.startPos = startPos;
			this.currentPart = currentPart;
			this.currentPartSize = currentPartSize;
		}
		
		public void run()
		{
			try {
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setConnectTimeout(5*1000);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accetp", "image/jpg,image/gif,image/jepg,image/pjepg,application/xaml+xml");
				conn.setRequestProperty("Accept-language", "zh-CN");
				conn.setRequestProperty("Charset","UTF-8");
				conn.setRequestProperty("Connection", "Keep-alive");
				
				InputStream inStream = conn.getInputStream();
				inStream.skip(this.startPos);
				byte[] buff = new byte[1024];
				int hasRead = 0;
				while(length < currentPartSize && (hasRead = inStream.read(buff))>0)
				{
					currentPart.write(buff,0,hasRead);
					length += hasRead;
					sleep(300);
				}
				currentPart.close();
				inStream.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public static void startDown(String url) throws Exception
	{
		final DownUtil downUtil = new DownUtil(url,"sink.png",2);
		downUtil.downLoad();
		
		/*for(int i=0; i<downUtil.threadNum;i++)
		{
			
			downUtil.threads[i].start();
		}*/
		
		while(downUtil.getCompleteRate()<1)
		{
			System.out.println(Thread.currentThread().getName()+"：已完成："+ downUtil.getCompleteRate());
			try{
				Thread.sleep(300);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"：已完成："+ downUtil.getCompleteRate());
		
		
	}
}
