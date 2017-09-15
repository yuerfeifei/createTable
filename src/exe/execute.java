package exe;

import java.util.List;

import dao.ParseAnnotation;
import util.GetClassName;
import util.GetProperties;

public class execute {
	//程序入口
	public static void createTable() throws Exception {
		String basePackage=GetProperties.getProperties("basepackage");
		ParseAnnotation p = new ParseAnnotation();
		List<String> result = GetClassName.getClassName(basePackage);
		for (String className : result) {
			System.out.println(className);
			if(className==null){
				continue;
			}
			boolean flg = p.createTable(className);
			if(flg==false){
				System.err.println("失败了！");
			}
		}
	}
}
