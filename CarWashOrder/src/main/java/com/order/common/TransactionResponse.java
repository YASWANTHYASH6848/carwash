package com.order.common;

import com.order.models.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

	private Order order;
	private String transactionId;
	private double amount;
	private String message;
	private Washer washer;
	public Washer getWasher() {
		return washer;
	}

	public void setWasher(Washer washer) {
		this.washer = washer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TransactionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionResponse(Order order, String transactionId, double amount, String message, Washer washer) {
		super();
		this.order = order;
		this.transactionId = transactionId;
		this.amount = amount;
		this.message = message;
		this.washer = washer;
	}
	
	

}