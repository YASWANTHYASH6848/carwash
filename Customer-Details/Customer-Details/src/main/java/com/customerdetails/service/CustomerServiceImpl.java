package com.customerdetails.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.customerdetails.exceptions.CustomerNotFoundException;
import com.customerdetails.exceptions.FieldIsNessasaryException;
import com.customerdetails.models.Customer;
import com.customerdetails.models.Order;
import com.customerdetails.models.OrderResponse;
import com.customerdetails.models.Payment;
import com.customerdetails.models.RatingReview;
import com.customerdetails.models.TransactionResponse;
import com.customerdetails.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Customer findByName(String name) {

		Customer customer = customerRepository.findAll().stream().filter(a -> a.getName().equalsIgnoreCase(name))
				.findAny().orElseThrow(null);

		if (customer == null) {

			throw new CustomerNotFoundException(
					"Customer with the provided name is not found, please use the name which was used at the time of registration!");

		} else {
			return customer;
		}
	}

	@Override
	public List<Customer> findByRole(String role) {

		return customerRepository.findAll().stream().filter(a -> a.getRole().equalsIgnoreCase(role))
				.collect(Collectors.toList());

	}

	@Override
	public Customer updateProfile(Customer customer, int customerId) {

		Customer existingCustomer = customerRepository.findById(customerId);

		existingCustomer.setName(customer.getName());
//		existingCustomer.setId(customer.getId());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setEmailAddress(customer.getEmailAddress());
		existingCustomer.setPassword(customer.getPassword());
		existingCustomer.setRole(customer.getRole());
		existingCustomer.setCarModel(customer.getCarModel());

		customerRepository.save(existingCustomer);

		return existingCustomer;
	}

	@Override
	public Customer addNewCustomer(Customer customer) {

		Random random = new Random();
		customer.setId(random.nextInt(9999));
		if (customer == null) {
			throw new FieldIsNessasaryException("Fill in complete details");
		} else {
			customer.setRole("Customer");
			return customerRepository.save(customer);
		}

	}

	@Override
	public OrderResponse placeOrder(String packName, String addOn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RatingReview giveRatingAndReview(RatingReview ratingReview) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> customerOrders(String name) {
		List<Order> orderList = null;

		try {
			ResponseEntity<List<Order>> claimResponse = restTemplate.exchange(
					"http://order-microservice/order/get-orders/" + name, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Order>>() {
					});
			if (claimResponse.hasBody()) {
				orderList = claimResponse.getBody();
			}
		} catch (RestClientException e) {
			e.printStackTrace();
		}

		return orderList;
	}

	@Override
	public void deleteOrderById(int id) {
		restTemplate.getForObject("\"http://order-microservice/order/delete/"+id,Order.class);
	}

}
