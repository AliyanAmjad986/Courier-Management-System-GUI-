package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.employee_panelDAO;
import database.Database_connection;
import model.adminPanel;
import model.employeePanel;
import veiw.AdminDashboardFrame;
import veiw.employee_dashboard_Frame;

public class employeePanelController implements employee_panelDAO {
	
	public static int totalCount;
	public static ArrayList <Integer> customer_ids = new ArrayList <Integer>();
	public static ArrayList <String>  customer_fullname = new ArrayList <String>();
	public static ArrayList <String> customer_username = new ArrayList <String>();
	public static ArrayList <String> customer_phonenumber = new ArrayList <String>();
	public static ArrayList <String> customer_cnic = new ArrayList <String>();
	public static ArrayList <String> customer_address = new ArrayList <String>();
	
	private String insert_query = "insert into customers (fullname , username, password, phone, cnic, address) values (?,?,?,?,?,?)";
	private String select_query = "select * from customers";
	private String update_query ="UPDATE customers SET fullname = ?, username = ?, phone =?, cnic =?, address = ? where id = ? "; 
	private String delete_query = "Delete From customers where id = ? ";
	private String count_query = "SELECT COUNT(id) FROM customers;";
	private String Receivers_querry = "Select fullname from customers";
	@Override
	public void customer_data_fetch() {
		  customer_fullname.clear();
		    customer_username.clear();
		    customer_ids.clear();
		    customer_phonenumber.clear();
		    customer_cnic.clear();
		    customer_address.clear();
		try {
			Connection con = null;
			con =  Database_connection.dbconnection();
			PreparedStatement ps = con.prepareStatement(select_query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customer_ids.add(rs.getInt("id"));
				customer_fullname.add(rs.getString("fullname"));
				customer_username.add(rs.getString("username"));
				customer_phonenumber.add(rs.getString("phone"));
				customer_cnic.add(rs.getString("cnic"));
				customer_address.add(rs.getString("address"));
				
				
			}
			System.out.println(customer_ids);
			System.out.println(customer_fullname);
			System.out.println(customer_username);
			System.out.println(customer_phonenumber);
			System.out.println(customer_cnic);
			System.out.println(customer_address);
			
			AdminDashboardFrame.message = "Save Successfully";
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			AdminDashboardFrame.message = e.getMessage();
		}
		
	}

	@Override
	public void customer_data_update() {
		try {
			Connection con = null;
			con =  Database_connection.dbconnection();
			PreparedStatement ps = con.prepareStatement(update_query);
			
			ps.setString(1, employee_dashboard_Frame.fnfrominput);
			ps.setString(2, employee_dashboard_Frame.unfrominput);
			ps.setString(3, employee_dashboard_Frame.phonefrominput);
			
			ps.setString(4, employee_dashboard_Frame.cnicfrominput);
			ps.setString(5, employee_dashboard_Frame.addressfrominput);
			ps.setInt(6, employee_dashboard_Frame.id_fromuser);
			int count = ps.executeUpdate();
			System.out.println(count+"thisss");
			if(count > 0) {
				System.out.println("Values Upadted");
				
				AdminDashboardFrame.message = "Save Successfully";
				
			}else {
				System.out.println("Problem");
			
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
			AdminDashboardFrame.message = e.getMessage();
		}
		
		
	}

	@Override
	public void customer_data_insert() {
		
		try {
			Connection con = null;
			con =  Database_connection.dbconnection();
			PreparedStatement ps = con.prepareStatement(insert_query);
			ps.setString(1, employeePanel.getCustomer_fullname());
			ps.setString(2, employeePanel.getCustomer_username());
			ps.setString(3,  new String (employeePanel.getCustomer_password()));
			ps.setString(4, employeePanel.getPhonenumber());
			ps.setString(5, employeePanel.getCNIC());
			ps.setString(6, employeePanel.getAddress());
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
	public void customre_data_delete() {
		try {
		Connection con = null;
		con =  Database_connection.dbconnection();
		PreparedStatement ps = con.prepareStatement(delete_query);
		ps.setInt(1, employee_dashboard_Frame.id_fromuser);
		int count = ps.executeUpdate();
		if(count > 0) {
			System.out.println("Deleted");
			
			AdminDashboardFrame.message = "Delete Succesfully";
			
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
	public void customer_count() {
		 
		    customer_ids.clear();
		   
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

	@Override
	public void customer_fullname() {
		  customer_fullname.clear();
		  
		try {
			Connection con = null;
			con =  Database_connection.dbconnection();
			PreparedStatement ps = con.prepareStatement(Receivers_querry);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {	
				customer_fullname.add(rs.getString("fullname"));
				
				
			}
			
			System.out.println(customer_fullname);
		
			
			AdminDashboardFrame.message = "Fetched";
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			AdminDashboardFrame.message = e.getMessage();
		}
		
	}

}
