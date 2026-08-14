package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database_connection {
public	static String url = "jdbc:mysql://localhost:3306/couriermanagementsystem";
public	static String user = "your user here";
public	static String dbpassword = "your password here";
	
	
	public static Connection dbconnection() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 return DriverManager.getConnection(url, user, dbpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
