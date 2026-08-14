package model;

public class Customer_Login {
	public static String username;
	public static  String password;
	

	public  Customer_Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public static String getUsername() {
		return username;
	}
	public  void setUsername(String username) {
		this.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public  void setPassword(String password) {
		this.password = password;
	}

	public void display() {
		System.out.println(username);
		System.out.println(password);
	}
	
	

}
