package util;

import java.io.File;

public class GetClassName {
	public static String[] getClassName(String dir) {
		String[] className = null;
		String path=System.getProperty("user.dir")+File.separator+"src"+File.separator+dir;
		System.out.println(path);
		File file = new File(path);		
		if (file.isDirectory()){
			File[] fileArray = file.listFiles();
			className=new String[fileArray.length];
			for(int i=0;i<fileArray.length;i++){
				String[] temp = fileArray[i].toString().split("\\\\");
				String fileName = temp[temp.length-1].replace(".", "!");
				temp = fileName.split("!");
				className[i]=temp[0];
			}
		}
		return className;
		
	}
}
