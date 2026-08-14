package model;

public class adminPanel {
	private  static  int employee_id;
private  static  String employee_fullname;
private  static String employee_username;
private static  char[] employee_password;
private static  String role;

public static int getEmployee_id() {
	return employee_id;
}


public static void setEmployee_id(int employee_id) {
	adminPanel.employee_id = employee_id;
}

public adminPanel( String employee_Fullname, String employee_Username, char[] pswfrominput, String employee_Role) {
	this.employee_fullname = employee_Fullname;
	this.employee_username = employee_Username;
	this.employee_password = pswfrominput;
	this.role = employee_Role;
	
}

public adminPanel( String id, String employee_Fullname, String employee_Username) {
	this.employee_fullname = employee_Fullname;
	this.employee_username = employee_Username;
	this.employee_id = Integer.parseInt(id);
	
	
}
public static String  getEmployee_fullname() {
	return employee_fullname;
}


public void setEmployee_fullname(String employee_fullname) {
	this.employee_fullname = employee_fullname;
}
public static String getEmployee_username() {
	return employee_username;
}
public void setEmployee_username(String employee_username) {
	this.employee_username = employee_username;
}
public static char[] getEmployee_password() {
	return employee_password;
}
public void setEmployee_password(char[] employee_password) {
	this.employee_password = employee_password;
}
public static String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


}
