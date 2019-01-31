package Database;

import java.io.Serializable;

public abstract class ServiceGirls implements Serializable {
	private int jobCode;
	private String name;
	private int age;
	private String body;
	protected double money;
	
	public abstract double getMoney();
	public ServiceGirls() {
		super();
	}
	public ServiceGirls(int jobCode, String name, int age, String body) {
		super();
		this.jobCode = jobCode;
		this.name = name;
		this.age = age;
		this.body = body;
	}
	public int getJobCode() {
		return jobCode;
	}
	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return this.getJobCode()+"-"+this.getName()+"-"+this.getAge()+"-"+this.getBody();
	}
}
