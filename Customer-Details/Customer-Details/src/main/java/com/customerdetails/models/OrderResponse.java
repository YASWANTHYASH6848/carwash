package com.customerdetails.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

	private Order order;
	private String status;

	public OrderResponse(Order order, String status) {
		super();
		this.order = order;
		this.status = status;
	}

	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
