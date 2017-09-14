package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class GetProperties {
	public static Map<String, Object> map = new HashMap<String, Object>();
	public static String getProperties(String key) throws Exception{
		String text = "";
		String path=System.getProperty("user.dir")+File.separator+"src"+File.separator+"setting.properties";
		File file = new File(path);
		FileReader fr = new FileReader(file);
		BufferedReader fStream = new BufferedReader(fr);
		String temp;
		
		while((temp= fStream.readLine())!=null){
			text = temp;
			map.put(text.split("=")[0], text.split("=")[1]);
		}
		return map.get(key).toString();
	}
	
}
