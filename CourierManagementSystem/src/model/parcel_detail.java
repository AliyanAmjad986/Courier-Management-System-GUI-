package model;

import java.util.Date;

import dao.parcel_DetailDAO;

public class parcel_detail   {
	private static int trackingId;
	private static String pickupAddress;
	private static String receiver;
	private static String sender;
	private static String parcelType;
	private static int weight;
	private static int price;
	private static Date bookingDate;
	private static Date expectedDeliveryDate;
	private static String currentStatus;
	public static int getTrackingId() {
		return trackingId;
	}
	public  void  setTrackingId(int trackingId) {
		this.trackingId = trackingId;
	}
	public static String getPickupAddress() {
		return pickupAddress;
	}
	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}
	public static String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public static String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public static String getParcelType() {
		return parcelType;
	}
	public void setParcelType(String parcelType) {
		this.parcelType = parcelType;
	}
	public static int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public static int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public static Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public static Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}
	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}
	public static String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public parcel_detail( String pickupAddress, String receiver, String sender, String parcelType,
			int weight, int price, Date bookingDate, Date expectedDeliveryDate, String currentStatus) {
		super();
		
		this.pickupAddress = pickupAddress;
		this.receiver = receiver;
		this.sender = sender;
		this.parcelType = parcelType;
		this.weight = weight;
		this.price = price;
		this.bookingDate = bookingDate;
		this.expectedDeliveryDate = expectedDeliveryDate;
		this.currentStatus = currentStatus;
	}
	



}
