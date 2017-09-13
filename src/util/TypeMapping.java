package util;

public class TypeMapping {
	public static Object typeMapping(Object value){
		if(value.equals("String")){
			value = "varchar";
			return value;
		}
		if(value.equals("Integer")){
			value = "int";
			return value;
		}
		System.err.println("未知格式！");
		return null;
	}
}
