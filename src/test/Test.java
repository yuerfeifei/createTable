package test;

import java.sql.SQLException;

import dao.ParseAnnotation;
import util.GetClassName;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String basePackage="entity";
		ParseAnnotation p = new ParseAnnotation();
		String[] result = GetClassName.getClassName(basePackage);
		for (String className : result) {
			System.out.println(basePackage+"."+className);
			boolean flg = p.createTable(basePackage+"."+className);
			if(flg){
				System.out.println("ok");
			}else{
				System.out.println("失败！");
			}
		}
	}
}
