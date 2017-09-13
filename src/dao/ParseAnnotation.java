package dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.SQLException;

import annotation.Param;
import annotation.TableName;
import util.MysqlConnect;
import util.TypeMapping;

public class ParseAnnotation {
	public boolean createTable(String className) throws ClassNotFoundException, SQLException  {
		//Student student = new Student();
		String sql = "";
		TableName tableName = null;
		boolean flg=false;
		//实例化实体类
		Class clazz = Class.forName(className);
		//获取类层级注解
		Annotation[] annotations = clazz.getAnnotations();
		if(annotations.length<1){
			System.err.println(annotations.length);
			return false;
		}
		tableName = (TableName)annotations[0];
		
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			Annotation[] a = field.getDeclaredAnnotations();
			if(a.length>0){
				flg=true;
			}
			for (Annotation annotation : a) {
				Param param = (Param) annotation;
				sql = sql+"`"+param.name()+"` "+TypeMapping.typeMapping(param.type())+"("+param.length()+")"+",";
			}
		}
		if(flg==false){
			return flg;
		}
		sql=sql.substring(0,sql.length()-1);
		sql="create table"+" "+"`"+tableName.name()+"`"+"("+sql+")";
		System.out.println(sql);
		MysqlConnect mConnect = new MysqlConnect("");
		mConnect.pst.executeUpdate(sql);
		return true;
	}
}
