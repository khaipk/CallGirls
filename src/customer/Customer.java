package customer;

public class Customer {
	private String id;
	private String name;
	private int age;
	private double totalMoney;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Customer(String id, String name, int age, double totalMoney) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.totalMoney = totalMoney;
	}
	public Customer() {
		super();
	}
	
	
}
