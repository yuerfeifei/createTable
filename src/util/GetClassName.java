package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetClassName {
	public static List<String> result = new ArrayList<>();
	public static List<String> getClassName(String dir){
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
					getClassName(dir+File.separator+fileName.getName());
					continue;
				}
				String temp = dir+File.separator+fileName.getName();
				String tempReplace = temp.replace("/", ".");
				tempReplace = tempReplace.replace(".java","");
				result.add(tempReplace);
				
			}
		}
		return result;
	}
}
