package com.customerdetails.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customerdetails.filter.JwtFilter;
import com.customerdetails.models.AuthRequest;
import com.customerdetails.models.AuthResponse;
import com.customerdetails.models.Customer;
import com.customerdetails.models.Order;
import com.customerdetails.repo.CustomerRepository;
import com.customerdetails.service.CustomUserDetailsService;
import com.customerdetails.service.CustomerServiceImpl;
import com.customerdetails.util.JwtUtil;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerServiceImpl customerServiceImpl;

	@Autowired
	private JwtFilter jwtFilter;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * 
	 * @param customer These are all the methods for Customer model.
	 */

	// Method to add customer
	@PostMapping("/add-customer")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		logger.info("Add customer is running");
		return customerServiceImpl.addNewCustomer(customer);
	}

	// Method to get customer by name
	@GetMapping("/get-customer/{name}")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable("name") String name) {
		Customer customer = customerServiceImpl.findByName(name);
		logger.trace("Get customer by name is running");
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	// Method to get customer by role
	@GetMapping("/get-customer-role/{role}")
	public List<Customer> getCustomerByRole(@PathVariable("role") String role){
		logger.trace("Get customer by role is running ");
		return customerServiceImpl.findByRole(role);
	}

	// Method to get all customers
	@GetMapping("/get-all-customer")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		logger.trace("Get all customer is running");

		return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
	}
	
	// Method to get customer by Id
	@GetMapping("/customer-id/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id) {
		logger.trace("Get customer By id is running");

		Customer customer = customerRepository.findById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}


	// Method to update the profile of customers
	@PutMapping("/update-profile/{id}")
	public ResponseEntity<Customer> updateProfile(@PathVariable("id") int id,
			@RequestBody Customer customer) {
		logger.trace("update customer profile is running");
		return new ResponseEntity<Customer>(customerServiceImpl.updateProfile(customer, id), HttpStatus.OK);

	}

	// Method to authenticate the user
	@PostMapping("/authenticate") // Authenticate a Customer (Existing)
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
				);
		logger.info("Authenticating the user!");
		}catch (BadCredentialsException e) {
			logger.error("invalid credentails");
			throw new Exception("Invalid Username or Password!",e);
		}
		final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUsername());
		final String token = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthResponse(token));
	}

	@GetMapping("/customer-only")
	public String heyCustomer() {
		return "This method only Accessible by Customer !";
	}
	
	
	// Method to return the user details	
	@GetMapping("/current-user")
	public UserDetails getCurrentUser(Authentication authentication) {
		logger.info("Getting the current user!");
		return this.customUserDetailsService.loadUserByUsername(authentication.getName());
	}

	@GetMapping("/current-user-name")
	public String getCurrentUserName(Authentication authentication) {
		return authentication.getName();
	}

	@GetMapping("/my-orders")
	public List<Order> myOrders() {
		logger.info("tracking my orders");
		return customerServiceImpl.customerOrders(jwtFilter.getLoggedInUserName());
	}

	@DeleteMapping("delete/{id}")
	public void deleteOrder(@PathVariable("id") int id) {
		this.customerServiceImpl.deleteOrderById(id);
	}
}