package com.order.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.order.models.Order;

public interface OrderRepository extends MongoRepository<Order, Integer>{

	
	
}
