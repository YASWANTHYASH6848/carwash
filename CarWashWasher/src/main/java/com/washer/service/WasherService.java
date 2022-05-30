package com.washer.service;

import java.util.List;

import com.washer.models.Order;
import com.washer.models.Washer;

public interface WasherService {

	public String washRequestFromCustomer();

	public Washer findByName(String name);

	public Washer updateProfile(Washer washer, int id);

	public Washer addNewWasher(Washer washer);
	
	public String washerChoice(Boolean option);

	public List<Order> washerOrders(String name);

}
