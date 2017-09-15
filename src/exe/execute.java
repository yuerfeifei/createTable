package exe;

import java.util.List;

import dao.ParseAnnotation;
import util.GetClassName;
import util.GetProperties;

public class execute {
	public static void main(String[] args) throws Exception {
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
