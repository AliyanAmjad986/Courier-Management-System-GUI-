package model;

import veiw.employee_dashboard_Frame;

public class employeePanel {
private static int id;
private static String customer_fullname;
private static String customer_username;
private static char[] customer_password;
private static String CNIC;
private static String Address;
private static String phonenumber;





public employeePanel(int id, String customer_fullname, String customer_username, char[] customer_password, String phonenumber, String cNIC,
		String address) {
	super();
	this.id = id;
	this.customer_fullname = customer_fullname;
	this.customer_username = customer_username;
	this.customer_password = customer_password;
	this.phonenumber = phonenumber;
	this.CNIC = cNIC;
	this.Address = address;
}

public employeePanel( String customer_fullname, String customer_username, char[] customer_password, String cnicfrominput,
		String phonenumber,String address) {
	super();
	this.id = id;
	this.customer_fullname = customer_fullname;
	this.customer_username = customer_username;
	this.customer_password = customer_password;
	this.phonenumber = phonenumber;
	this.CNIC = cnicfrominput;
	this.Address = address;
}
public static int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public static String getCustomer_fullname() {
	return customer_fullname;
}
public  void setCustomer_fullname(String customer_fullname) {
	this.customer_fullname = customer_fullname;
}
public static String getCustomer_username() {
	return customer_username;
}
public void setCustomer_username(String customer_username) {
	this.customer_username = customer_username;
}
public static char[] getCustomer_password() {
	return customer_password;
}
public  void setCustomer_password(char[] customer_password) {
	this.customer_password = customer_password;
}
public static String getCNIC() {
	return CNIC;
}
public void setCNIC(String cNIC) {
	this.CNIC = cNIC;
}
public static String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public static String getPhonenumber() {
	return phonenumber;
}

public static void setPhonenumber(String phonenumber) {
	employeePanel.phonenumber = phonenumber;
}

}


