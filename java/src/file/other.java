package file;

import java.io.File;
import java.io.IOException;

public class other {

	public void ShowFile() throws IOException
	{
		File file = new File("test.txt");
		
		if (!file.exists())
		{
			file.createNewFile();
		}
		
		File dir =  new File("in");
		dir.mkdirs();
		
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getParent());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getCanonicalPath());
		System.out.println(file.getAbsolutePath().length());
		
		String srcfileDir = file.getAbsolutePath().substring(0,(int)(file.getAbsolutePath().length()-file.getName().length()));
		srcfileDir = srcfileDir.replace("\\", "/");
		System.out.println(srcfileDir);
	}
}
