package load;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class CompileClassLoader extends ClassLoader {
	private byte[] getBytes(String filename) throws IOException{
		File file = new File(filename);
		
		long len = file.length();
		byte [] raw = new byte[(int) len];
		
		try(FileInputStream fin = new FileInputStream(file))
		{
			
			int r = fin.read(raw);
			if(r != len){
				throw new IOException("无法读取全部文件");
			}
			return raw;
		}
		
	}
	
	private boolean compile(String javaFile) throws IOException{
		
		Process p = Runtime.getRuntime().exec("javac " +javaFile);
		try{
			p.waitFor();
		}
		catch(InterruptedException ie){
			System.out.println(ie);
		}
		int ret = p.exitValue();
		
		return ret == 0;
	}
	
	//重写了方法类
	protected Class<?> findClass(String name) throws ClassNotFoundException
	{
		Class clazz = null;
		String fileStub = name.replace(".","/");
		String javaFileName = fileStub+".java";
		String classFileName = fileStub+".class";
		
		File javaFile = new File (javaFileName);
		File classFile = new File(classFileName);
		
		System.out.println(classFile.getAbsolutePath());
		
		if( javaFile.exists() && (!classFile.exists() || javaFile.lastModified()> classFile.lastModified()))
		{
			try
			{
				if ( !compile(javaFileName) || !classFile.exists())
				{
					throw new ClassNotFoundException(javaFileName);
				}
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		
		if(classFile.exists()){
			try{
				byte [] raw = getBytes(classFileName);
				clazz = defineClass(name,raw,0,raw.length);
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
			
		}
		
		if(clazz == null)
		{
			throw new ClassNotFoundException(name);
		}
		return clazz;
	}
	
	public static void UseDynamicCompile(String[] args) throws Exception
	{
		if (args.length<1)
		{
			System.out.println("java CompileClassLoader ClassName");
		}
		
		String progClass = args[2];
		String [] progArgs = new String[args.length-1];
		
		System.arraycopy(args, 1, progArgs, 0, progArgs.length);
		
		CompileClassLoader ccl = new CompileClassLoader();
		
		Class<?> clazz = ccl.loadClass(progClass);
		
		Method main = clazz.getMethod("printHello");
		
		Object argsArray[] = {progArgs};
		//main.invoke(null, argsArray);
		main.invoke(null);
		
		
	}
	
}
