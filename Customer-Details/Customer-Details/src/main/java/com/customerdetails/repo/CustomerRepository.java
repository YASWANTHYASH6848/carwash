package com.customerdetails.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.customerdetails.models.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {

    public List<Customer> findAll();
    public Customer findByName(String name);
    public Customer findById(int id);

}