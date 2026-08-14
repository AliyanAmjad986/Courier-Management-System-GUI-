package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.adminPanelDAO;
import database.Database_connection;
import model.adminPanel;
import veiw.AdminDashboardFrame;

public class adminPanelController implements adminPanelDAO {
	public static int totalCount;
private String insert_query = "insert into employee (fullname , username, password, role) values (?,?,?,?)";
private String select_query = "select * from employee where role = 'employee'";
private String update_query ="UPDATE employee SET fullname = ?, username = ? where id = ? ";
private String delete_query = "DELETE FROM employee where id = ?";
private String count_query = "SELECT COUNT(id) FROM employee where role = 'employee'";


public static ArrayList   employee_fullname = new ArrayList();
public static ArrayList  employee_username = new ArrayList();
public static ArrayList <Integer>  employee_id = new ArrayList <Integer>();
public static ArrayList  employee_role = new ArrayList();
@Override
	public void employee_data_update() {
	
	try {
		System.out.println("froooom"+adminPanel.getEmployee_id());
		Connection con = null;
		con =  Database_connection.dbconnection();
		PreparedStatement ps = con.prepareStatement(update_query);
		ps.setString(1, adminPanel.getEmployee_fullname());
		ps.setString(2, adminPanel.getEmployee_username());
		ps.setInt(3, adminPanel.getEmployee_id());
		int count = ps.executeUpdate();
		if(count > 0) {
			System.out.println("Values Update");
			
			AdminDashboardFrame.message = "Update Successfully";
			
		}else {
			System.out.println("Problem");
		
		}
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
		AdminDashboardFrame.message = e.getMessage();
	}
		
	}

	@Override
	public void employee_data_insert() {
		String password = new String(adminPanel.getEmployee_password()) ;
		try {
			Connection con = null;
			con =  Database_connection.dbconnection();
			PreparedStatement ps = con.prepareStatement(insert_query);
			ps.setString(1, adminPanel.getEmployee_fullname());
			ps.setString(2, adminPanel.getEmployee_username());
			ps.setString(3, password);
			ps.setString(4, adminPanel.getRole());
			int count = ps.executeUpdate();
			if(count > 0) {
				System.out.println("Values Inserted");
				
				AdminDashboardFrame.message = "Save Successfully";
				
			}else {
				System.out.println("Problem");
			
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			AdminDashboardFrame.message = e.getMessage();
		}
		
	}

	@Override
	public void employee_data_delete() {
		
		try {
			Connection con = null;
			con =  Database_connection.dbconnection();
			PreparedStatement ps = con.prepareStatement(delete_query);
			
			ps.setInt(1, adminPanel.getEmployee_id());
			int count = ps.executeUpdate();
			if(count > 0) {
				System.out.println("Deleted Successfully");
				
				AdminDashboardFrame.message = "Deleted Successfully";
				
			}else {
				System.out.println("Problem");
			
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			AdminDashboardFrame.message = e.getMessage();
		}
		
	}

	@Override
	public void employee_data_fetch() {
		try {
			Connection con = null;
			con =  Database_connection.dbconnection();
			PreparedStatement ps = con.prepareStatement(select_query);
			ResultSet rs = ps.executeQuery();
			employee_fullname.clear();
			employee_username.clear();
			employee_id.clear();
			employee_role.clear();
			while (rs.next()) {
				employee_id.add(rs.getInt("id"));
				employee_fullname.add(rs.getString("fullname"));
				employee_username.add(rs.getString("username"));
				employee_role.add(rs.getString("role"));
			}
			System.out.println(employee_id);
			System.out.println(employee_fullname);
			System.out.println(employee_username);
			System.out.println(employee_role);
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			AdminDashboardFrame.message = e.getMessage();
		}

		
	}

	@Override
	public void employee_count() {
		try {
			Connection con = null;
			con =  Database_connection.dbconnection();
			PreparedStatement ps = con.prepareStatement(count_query);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			    totalCount = rs.getInt(1); 
			    System.out.println("Total Rows: " + totalCount);
			}
			
			
//			
			
			
			AdminDashboardFrame.message = "Save Successfully";
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			AdminDashboardFrame.message = e.getMessage();
		}
		
	}

}
