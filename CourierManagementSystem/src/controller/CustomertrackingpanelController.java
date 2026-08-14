package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CustomerPanelDAO;
import database.Database_connection;
import veiw.AdminDashboardFrame;
import veiw.Customerpanel_Frame;

public class CustomertrackingpanelController implements CustomerPanelDAO {
	int tracking_ids;
	public static String Receivers ;
	public static String Sender  ;
	public static int Weights ;
	public static int prices ;
	public static  Date booking_dates;
	public static  Date expected_date;
	public static  String parcel_types;
	public static String pickup_address;
	public static String current_status;
String select_query = "SELECT * from parcel where tracking_id = ?";
	
	
	
	@Override
	public void cust_parcel_fetch() {
		
		try{
			Connection con = null;
		
		con =  Database_connection.dbconnection();
		PreparedStatement ps = con.prepareStatement(select_query);
		ps.setInt(1, Customerpanel_Frame.tracking_id_from_input);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
		
			Receivers = rs.getString("receiver");
			Sender = rs.getString("sender");
			Weights = rs.getInt("weight");
			prices = rs.getInt("price");
			parcel_types = rs.getString("parcel_type");
			java.sql.Date bookingDate = rs.getDate("booking_date");
			java.sql.Date expectedDate = rs.getDate("expected_delivery_date");
			booking_dates =(bookingDate);
			expected_date =(expectedDate);
			pickup_address = rs.getString("pickup_address");
			current_status = rs.getString("current_status");
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
			
	
	
}}
