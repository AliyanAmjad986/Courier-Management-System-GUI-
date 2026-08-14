package model;

public class Employee_login {
	private static String usernamefromtxt;
	 private static String passwordfromtxt;
	 private static String rolefromcombo;
	 
	 
 public  Employee_login(String usernamefromtxt, String passwordfromtxt, String rolefromcombo) {
		super();
		this.usernamefromtxt = usernamefromtxt;
		this.passwordfromtxt = passwordfromtxt;
		this.rolefromcombo = rolefromcombo;
	}
 public Employee_login() {
	 
 }
 
 public static String getUsernamefromtxt() {
	return usernamefromtxt;
}
 public  void setUsernamefromtxt(String usernamefromtxt) {
	this.usernamefromtxt = usernamefromtxt;
 }
 public static String getPasswordfromtxt() {
	return passwordfromtxt;
 }
 public  void setPasswordfromtxt(String passwordfromtxt) {
	this.passwordfromtxt = passwordfromtxt;
 }
 public static String getRolefromcombo() {
	return rolefromcombo;
 }
 public void setRolefromcombo(String rolefromcombo) {
	this.rolefromcombo = rolefromcombo;
 }
 public void display() {
	 System.out.println(usernamefromtxt+"From eployee");
	 System.out.println(passwordfromtxt+"From eployee");
	 System.out.println(rolefromcombo+"From eployee");
 }
 @Override
 public String toString() {
	return "Login [usernamefromtxt=" + usernamefromtxt + ", passwordfromtxt=" + passwordfromtxt + ", rolefromcombo="
			+ rolefromcombo + "]";
 }

 
}
