package test;

import java.util.List;

import util.GetClassName;

public class test {
	public static void main(String[] args) {
		List<String> result = GetClassName.getClassName("entity");
		System.out.println(result);
	}
}
