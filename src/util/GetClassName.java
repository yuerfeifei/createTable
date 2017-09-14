package util;

import java.io.File;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class GetClassName {
	public static String basePath=System.getProperty("user.dir")+File.separator+"src"+File.separator;
	public static String[] className = null;
	public static String[] getClassName(String dir) {
		
		String path= basePath+dir+File.separator;
		System.out.println(path);
		File file = new File(path);		
		if (file.isDirectory()){
			File[] fileArray = file.listFiles();
			className=new String[fileArray.length];
			for(int i=0;i<fileArray.length-1;i++){
				if(fileArray[i].isDirectory()){
					String[] temp = new String[50];
					temp=fileArray[i].toString().split("\\\\");
					getClassName(dir+File.separator+temp[temp.length-1]);
				}else{
				System.err.println(fileArray[i].toString());
				String[] temp = fileArray[i].toString().split("\\\\");
				String fileName = temp[temp.length-1].replace(".", "!");
				temp = fileName.split("!");
				className[i]=temp[0];
				}
			}
		}
		
		return className;
		
	}
}
