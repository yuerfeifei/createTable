package test;

import java.util.Map;

import util.GetProperties;

public class test {
	private static Map<String, Object> settiingText;
	public static void main(String[] args) throws Exception {
		GetProperties getProperties = new GetProperties();
		System.out.println(settiingText.get("driver"));
	}
	
}
