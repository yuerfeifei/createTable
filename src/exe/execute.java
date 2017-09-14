package exe;

import dao.ParseAnnotation;
import util.GetClassName;
import util.GetProperties;

public class execute {
	public static void main(String[] args) throws Exception {
		String basePackage=GetProperties.getProperties("basepackage");
		ParseAnnotation p = new ParseAnnotation();
		String[] result = GetClassName.getClassName(basePackage);
		for (String className : result) {
			System.out.println(basePackage+"."+className);
			boolean flg = p.createTable(basePackage+"."+className);
			if(flg==false){
				System.err.println("失败了！");
			}
		}
	}
}
