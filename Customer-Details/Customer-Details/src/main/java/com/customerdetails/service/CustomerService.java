package com.customerdetails.service;

import java.util.List;

import com.customerdetails.models.Customer;
import com.customerdetails.models.Order;
import com.customerdetails.models.OrderResponse;
import com.customerdetails.models.RatingReview;

public interface CustomerService{

	public Customer findByName(String name);
	
	public List<Customer> findByRole(String role);

    public Customer updateProfile(Customer customer, int id);
    
    public Customer addNewCustomer(Customer customer);

    public OrderResponse placeOrder(String packName, String addOn) throws Exception;

    public RatingReview giveRatingAndReview(RatingReview ratingReview);

    public List<Order> customerOrders(String name);
    
    public void deleteOrderById(int id);
}