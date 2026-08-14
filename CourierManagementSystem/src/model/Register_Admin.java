package model;

public class Register_Admin {
private static String fullname;
private static String username;
private static String password;
private static String role;
public static String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public static String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public static String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public static String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Register_Admin(String fullname, String username, String password, String role) {
	super();
	this.fullname = fullname;
	this.username = username;
	this.password = password;
	this.role = role;
}

public void display() {
	System.out.println(fullname);
	System.out.println(username);
	System.out.println(password);
	System.out.println(role); 
}



}
