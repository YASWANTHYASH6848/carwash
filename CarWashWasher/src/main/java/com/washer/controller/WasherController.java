package com.washer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.washer.models.AuthRequest;
import com.washer.models.AuthResponse;
import com.washer.models.Washer;
import com.washer.repo.WasherRepository;
//import com.washer.service.CustomUserDetailsService;
import com.washer.service.WasherServiceImpl;
//import com.washer.util.JwtUtil;

@RestController
@RequestMapping("/washer")
public class WasherController {
	
	Logger logger = LoggerFactory.getLogger(WasherController.class);

	@Autowired
	private WasherServiceImpl serviceImpl;
	
	@Autowired
	private WasherRepository repository;
	
	
//	@Autowired
//	AuthenticationManager authenticationManager;
	
//	@Autowired
//	CustomUserDetailsService customUserDetailsService;
//	
//	@Autowired
//	JwtUtil jwtUtil;
	
	/**
	 * 
	 * @param washer
	 * @return These are the api's for washer service.
	 */
	
	//Method to add washer
	@PostMapping("/add-washer")
	public Washer addWasher(@RequestBody Washer washer) {
		logger.trace("Add Washer Running");
		return serviceImpl.addNewWasher(washer);
	}
	
	
	//Method to get the washer by name
	@GetMapping("/get-washer/{name}")
	public ResponseEntity<Washer> getWasherByName(@PathVariable("name") String name){
		logger.trace("Get Washer by Name Running");
		Washer washer = serviceImpl.findByName(name);
		return new ResponseEntity<Washer>(washer, HttpStatus.OK);
	}


	// Method to get all washers
	@GetMapping("/get-all-washer")
	public ResponseEntity<List<Washer>> getAllCustomer() {
		logger.trace("Get All Washer Running");
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}
	
	
	
	// Method to update the profile of washers
	@PutMapping("/update-profile/{id}")
	public ResponseEntity<Washer> updateProfile(@PathVariable("id") int id,
			@RequestBody Washer washer) {
		
		logger.trace(" Washer Running");
		return new ResponseEntity<Washer>(serviceImpl.updateProfile(washer, id), HttpStatus.OK);
	}

	// Method to authenticate the user
//	@PostMapping("/authenticate") // Authenticate a Washers (Existing)
//	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
//		try {
//		authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
//				);
//		}catch (BadCredentialsException e) {
//			throw new Exception("Invalid Username or Password!",e);
//		}
//		final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUsername());
//		final String token = jwtUtil.generateToken(userDetails);
//		return ResponseEntity.ok(new AuthResponse(token));
//	}
}
