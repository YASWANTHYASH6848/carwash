package com.order.service;

import java.util.List;

import com.order.models.Order;

public interface OrderService {

	public Order placeOrder(Order order);

	public List<Order> getOrderListByName(String name);

	public Order getOrderByCustomerName(String customerName);

	public void deleteOrderById(int id);

}
