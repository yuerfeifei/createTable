package util;

import java.io.File;

public class GetClassName {
	public static String[] getClassName(String dir){
		String basePath=System.getProperty("user.dir")+File.separator+"src";
		String path = basePath+File.separator+dir+File.separator;
		File file = new File(path);
		if(file.isDirectory()){
			File[] fileArray = file.listFiles();
			if(fileArray.length<1){
				return null;
			}
			for (File fileName : fileArray) {
				if(fileName.isDirectory()){
					getClassName(dir+File.separator+fileName);
				}
				System.out.println(dir+File.separator+fileName.getName());
			}
		}
		
		return null;
	}
}
