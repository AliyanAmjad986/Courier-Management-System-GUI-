package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.adminLoginDAO;
import database.Database_connection;
import veiw.AdminLogin_Frame;

public class adminLoginController implements adminLoginDAO {
private String fetch_query = "Select username, password from admin where username = ? AND password = ?";
public  String password;
public  String username;
public String fetched_username;
public String fetched_password;
public String userrole_input;

@Override
	public void fetchlogin_details() {
	fetched_username = AdminLogin_Frame.username_from_input.trim();
	fetched_password = AdminLogin_Frame.password_from_input.trim();
	userrole_input = AdminLogin_Frame.userrole_from_input;
		Connection con = null;
		 try {
			
			con = Database_connection.dbconnection();
			PreparedStatement ps = con.prepareStatement(fetch_query);
			ps.setString(1, fetched_username);
			ps.setString(2, fetched_password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			username= 	rs.getString("username"); 
			password = rs.getString("password");
			}
			System.out.println(username);
			System.out.println(password);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
