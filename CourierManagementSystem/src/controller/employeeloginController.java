package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.EmployeeLoginDAO;

import database.Database_connection;
import model.Employee_login;


public class employeeloginController implements EmployeeLoginDAO{
	

	public String username;
	public String password;
     String query = "Select username, password from employee where username = ? AND password = ?";
	 @Override
	public void fetchingemployee_db() {
			String username_from_input = Employee_login.getUsernamefromtxt() ;
			
		 String password_from_input = Employee_login.getPasswordfromtxt();
			 String Role = Employee_login.getRolefromcombo(); 
		 Connection con = null;
			try {			 
						con = Database_connection.dbconnection();
						PreparedStatement ps = con.prepareStatement(query);
						ps.setString(1, username_from_input);
						ps.setString(2, password_from_input);
						ResultSet rs = ps.executeQuery();
						while(rs.next()) {
							username = rs.getString("username");
							password = rs.getString("password");
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
