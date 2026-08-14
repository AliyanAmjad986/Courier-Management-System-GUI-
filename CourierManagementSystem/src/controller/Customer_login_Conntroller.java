package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.Customer_Login_PanelDAO;
import database.Database_connection;
import model.Customer_Login;


public class Customer_login_Conntroller implements Customer_Login_PanelDAO {
String query = "Select username, password from customers where username = ? AND password = ?";
public static String username;
public static String password;	
//public static String username_from_input = Customer_Login.getUsername();
//public static String password_from_input= Customer_Login.getPassword();
@Override
	
	public void login() {
	  String username_from_input = Customer_Login.getUsername();
	  String password_from_input= Customer_Login.getPassword();
		
		Connection con = null;
			try {			 
						con = Database_connection.dbconnection();
						PreparedStatement ps = con.prepareStatement(query);
						
						ps.setString(1, username_from_input);
						
						ps.setString(2, password_from_input);
						ResultSet rs = ps.executeQuery();
						
						if (rs.next()) {
						    username = rs.getString("username");
						    password = rs.getString("password");

						    System.out.println(username + " From DB");
						    System.out.println(password + " From DB");
						} else {
						    System.out.println("Invalid username or password");
						}
						System.out.println(username+"From db");
						System.out.println(password+"From db");
						System.out.println(username_from_input+"From db");
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
	}

}
