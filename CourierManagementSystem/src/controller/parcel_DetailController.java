package controller;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
//import java.sql.Date;
import dao.parcel_DetailDAO;
import database.Database_connection;
import model.adminPanel;
import model.parcel_detail;
import veiw.AdminDashboardFrame;
import veiw.employee_dashboard_Frame;
public class parcel_DetailController implements parcel_DetailDAO {
	public static ArrayList  tracking_ids = new ArrayList();
	public static ArrayList Receivers = new  ArrayList ();
	public static ArrayList  Sender = new ArrayList ();
	public static ArrayList  Weights = new  ArrayList ();
	public static ArrayList prices = new ArrayList();
	public static ArrayList  booking_dates= new ArrayList();
	public static ArrayList  expected_date= new ArrayList();
	public static ArrayList  parcel_types = new ArrayList();
	public static ArrayList  pickup_address= new ArrayList();
	public static ArrayList  current_status= new ArrayList ();
	public static int total_parcel;
	public static int total_in_pending_parcels;
	public static int total_in_transists_parcels;
	public static int total_delivered_parcels;
	public static int total_delivery_failed_parcels;
	
	
	private String insert_query = "INSERT INTO parcel (pickup_address, receiver, sender, parcel_type, weight, price, booking_date, expected_delivery_date, current_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private String total_parcels = "SELECT COUNT(tracking_id) FROM parcel";
	private String total_in_pending_parcel = "SELECT COUNT(current_status) FROM parcel where current_status = 'pending'";
	private String total_in_transists_parcel = "SELECT COUNT(current_status) FROM parcel where current_status ='In Transit'";
	private String total_delivered_parcel = "SELECT COUNT(current_status) FROM parcel where current_status ='Delivered'";
	private String total_delivery_failed_parcel = "SELECT COUNT(current_status) FROM parcel where current_status ='Delivery Failed'";
	private String select_query = "SELECT * from  parcel";
	
	
@Override
	public void parcel_detail_insert() {
		try {
			Connection con = null;
			con =  Database_connection.dbconnection();
			PreparedStatement ps = con.prepareStatement(insert_query);
			ps.setString(1, parcel_detail.getPickupAddress());
			ps.setString(2, parcel_detail.getReceiver());
			ps.setString(3, parcel_detail.getSender());
			ps.setString(4, parcel_detail.getParcelType());
			ps.setInt(5, parcel_detail.getWeight());
			ps.setInt(6, parcel_detail.getPrice());
			ps.setDate(7, new java.sql.Date(parcel_detail.getBookingDate().getTime()));
			ps.setDate(8, new java.sql.Date(parcel_detail.getExpectedDeliveryDate().getTime()));
			ps.setString(9, parcel_detail.getCurrentStatus());
			
			System.out.println(parcel_detail.getPrice());
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
public void parcel_detail_fetch() {
	tracking_ids.clear();
	Receivers.clear();
	Sender.clear();
	Weights.clear();
	prices.clear();
	booking_dates.clear();
	expected_date.clear();
	parcel_types.clear();
	pickup_address.clear();
	current_status.clear();
	try{
		Connection con = null;
	
	con =  Database_connection.dbconnection();
	PreparedStatement ps = con.prepareStatement(select_query);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		tracking_ids.add(rs.getInt("tracking_id"));
		Receivers.add(rs.getString("receiver"));
		Sender.add(rs.getString("sender"));
		Weights.add(rs.getString("weight"));
		prices.add(rs.getString("price"));
		parcel_types.add(rs.getString("parcel_type"));
		java.sql.Date bookingDate = rs.getDate("booking_date");
		java.sql.Date expectedDate = rs.getDate("expected_delivery_date");
		booking_dates.add((bookingDate));
		expected_date.add(expectedDate);
		pickup_address.add(rs.getString("pickup_address"));
		current_status.add(rs.getString("current_status"));
	}
	System.out.println(tracking_ids);
	System.out.println(Receivers);
	System.out.println(Sender);
	System.out.println(Weights);
	System.out.println(prices);
	System.out.println(booking_dates);
	System.out.println(parcel_types);
	System.out.println(expected_date);
	System.out.println(pickup_address);
	System.out.println(current_status);
	}catch (Exception e) {
		e.printStackTrace();
		
	}
		
	
	
}
@Override
public void total_parcel_fetch() {
	try{
		Connection con = null;
	
	con =  Database_connection.dbconnection();
	PreparedStatement ps = con.prepareStatement(total_parcels);
	ResultSet rs = ps.executeQuery();
	if (rs.next()) {
	    total_parcel = rs.getInt(1); 
	    System.out.println("Total Rows: " + total_parcel);
	}
	System.out.println(tracking_ids);
	
	}catch (Exception e) {
		e.printStackTrace();
		
	}
	
	
}
@Override
public void total_pending_fetch() {
	try{
		Connection con = null;
	
	con =  Database_connection.dbconnection();
	PreparedStatement ps = con.prepareStatement(total_in_pending_parcel);
	ResultSet rs = ps.executeQuery();
	if (rs.next()) {
	    total_in_pending_parcels = rs.getInt(1); 
	    System.out.println("Total Rows: " + total_in_pending_parcels);
	}
	System.out.println( total_in_pending_parcels);
	
	}catch (Exception e) {
		e.printStackTrace();
		
	}
	
}
@Override
public void total_in_transist() {
	try{
		Connection con = null;
	
	con =  Database_connection.dbconnection();
	PreparedStatement ps = con.prepareStatement(total_in_transists_parcel);
	ResultSet rs = ps.executeQuery();
	if (rs.next()) {
	    total_in_transists_parcels = rs.getInt(1); 
	    System.out.println("Total Rows: " + total_in_transists_parcels);
	}
	System.out.println(tracking_ids);
	
	}catch (Exception e) {
		e.printStackTrace();
		
	}
	
}


public void total_in_delivered() {
	try{
		Connection con = null;
	
	con =  Database_connection.dbconnection();
	PreparedStatement ps = con.prepareStatement(total_delivered_parcel);
	ResultSet rs = ps.executeQuery();
	if (rs.next()) {
	    total_delivered_parcels = rs.getInt(1); 
	    System.out.println("Total Rows: " + total_delivered_parcels);
	}
	System.out.println(total_delivered_parcels);
	
	}catch (Exception e) {
		e.printStackTrace();
		
	}
	
}
@Override
public void total_in_delivery_failed() {
	try{
		Connection con = null;
	
	con =  Database_connection.dbconnection();
	PreparedStatement ps = con.prepareStatement(total_delivery_failed_parcel);
	ResultSet rs = ps.executeQuery();
	if (rs.next()) {
	    total_delivery_failed_parcels = rs.getInt(1); 
	    System.out.println("Total Rows: " + total_delivery_failed_parcels);
	}
	System.out.println(total_delivery_failed_parcels);
	
	}catch (Exception e) {
		e.printStackTrace();
		
	}
	
}
private String update_query = "UPDATE parcel set receiver = ?, sender = ?, weight = ? ,parcel_type = ?, price = ?, booking_date = ?, expected_delivery_date = ?, pickup_address = ?, current_status = ? where tracking_id = ? ";
@Override
public void parcel_detail_update() {
	try {
		Connection con = null;
		con =  Database_connection.dbconnection();
		PreparedStatement ps = con.prepareStatement(update_query);
		
		ps.setString(1, employee_dashboard_Frame.receiver_from_input);
		ps.setString(2, employee_dashboard_Frame.sender_from_input);
		ps.setInt(3, employee_dashboard_Frame.weight_from_input);
		ps.setString(4, employee_dashboard_Frame.parcelType_from_input);
		
		ps.setInt(5, employee_dashboard_Frame.price_from_input);
		
		ps.setDate(6, new java.sql.Date( employee_dashboard_Frame.bookingDate_from_input.getTime()));
		ps.setDate(7, new java.sql.Date (employee_dashboard_Frame.expectedDeliveryDate_from_input.getTime()));
		ps.setString(8, employee_dashboard_Frame.pickadd_input);
		ps.setString(9, employee_dashboard_Frame.currentStatus_from_input);
		ps.setInt(10, employee_dashboard_Frame.tracking_id_from_input);
		
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



	
	
	
	
}
