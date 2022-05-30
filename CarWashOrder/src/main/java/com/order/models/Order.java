package com.order.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	private ObjectId _id;
	private int orderId;
	private String washName;
	private String carModel;
	private double amount;
	private String customerName;
	private Date date;
	private String paymentStatus;
	private String emailAddress;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getWashName() {
		return washName;
	}

	public void setWashName(String washName) {
		this.washName = washName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date2) {
		this.date = date2;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Order(ObjectId _id, int orderId, String washName, String carModel, double amount, String customerName,
			Date date, String paymentStatus, String emailAddress) {
		super();
		this._id = _id;
		this.orderId = orderId;
		this.washName = washName;
		this.carModel = carModel;
		this.amount = amount;
		this.customerName = customerName;
		this.date = date;
		this.paymentStatus = paymentStatus;
		this.emailAddress = emailAddress;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
