package dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import annotation.Param;
import annotation.TableName;
import util.MysqlConnect;
import util.TypeMapping;

public class ParseAnnotation {
	public boolean createTable(String className) throws Exception  {
		//Student student = new Student();
		String sql = "";
		TableName tableName = null;
		boolean flg=false;
		//实例化实体类
		Class clazz = Class.forName(className);
		//获取类层级注解
		Annotation[] annotations = clazz.getAnnotations();
		if(annotations.length<1){
			System.out.println("未发现注解，跳过。。。。。。。。");
			return true;
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
		System.out.println("正在创建"+tableName.name()+"表。。。。。。。。");
		
		MysqlConnect mConnect = new MysqlConnect("");
		try {
			System.out.println(sql);
			mConnect.pst.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(tableName.name()+"已存在。。。。。。。。");
			return true;
		}
		System.out.println(tableName.name()+"表创建成功！");
		return true;
	}
}
