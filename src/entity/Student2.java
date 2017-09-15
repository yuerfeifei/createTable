package entity;

import annotation.Param;
import annotation.TableName;

@TableName(name="test")
public class Student2 {
	@Param(name="testname",type="String")
	private String name;
	@Param(name="testage",type="Integer")
	private String age;
	@Param(name="testcity",type="String")
	private String city;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
