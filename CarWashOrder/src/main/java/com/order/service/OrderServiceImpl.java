package com.order.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.order.exception.OrderNotFoundException;
import com.order.models.Order;
import com.order.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestTemplate restTemplate;

	private final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public List<Order> getOrderListByName(String name) {
		List<Order> orderList = orderRepository.findAll().stream()
				.filter(a -> a.getCustomerName().equalsIgnoreCase(name)).collect(Collectors.toList());
		if (orderList == null) {
			throw new OrderNotFoundException("Sorry, No order found with the provided name");
		}

		return orderList;
	}

	@Override
	public Order placeOrder(Order order) {

		Random random = new Random();
		order.setOrderId(random.nextInt(99999999));
		order.setPaymentStatus("pending");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		order.setDate(date);
		return orderRepository.save(order);

	}

	@Override
	public Order getOrderByCustomerName(String customerName) {
		Order order = orderRepository.findAll().stream().filter(a -> a.getCustomerName().equalsIgnoreCase(customerName))
				.findAny().orElseThrow(null);
		return order;
	}

	@Override
	public void deleteOrderById(int id) {
		Order order = new Order();
		orderRepository.deleteById(id);
	}

}
