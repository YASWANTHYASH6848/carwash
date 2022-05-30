package com.washer.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.exception.FieldIsNessasaryException;
//import com.washer.filter.JwtFilter;
import com.washer.models.Order;
import com.washer.models.Washer;
import com.washer.repo.WasherRepository;

@Service
public class WasherServiceImpl implements WasherService {
	
//	@Autowired
//	private JwtFilter jwtFilter;

	@Autowired
	private WasherRepository washerRepository;

	String msg;

    String washerName;

//    //Logged in Washer-Name
//    public String washerName() {
//        washerName = jwtFilter.getLoggedInUserName();
//        return jwtFilter.getLoggedInUserName();
//    }
	
	@Override
	public String washRequestFromCustomer() {
		return msg;
	}

	@Override
	public Washer findByName(String name) {
		return washerRepository.findAll().stream().filter(a -> a.getName().equalsIgnoreCase(name)).findAny()
				.orElse(null);
	}

	@Override
	public Washer updateProfile(Washer washer, int id) {
		Washer existingWasher = washerRepository.findById(id);

		existingWasher.setName(washer.getName());
//		existingCustomer.setId(customer.getId());
		existingWasher.setAddress(washer.getAddress());
		existingWasher.setEmail(washer.getEmail());
		existingWasher.setPassword(washer.getPassword());
		existingWasher.setRole(washer.getRole());
		washerRepository.save(existingWasher);

		return existingWasher;
	}

	@Override
	public Washer addNewWasher(Washer washer) {
		Random random = new Random();
		washer.setId(random.nextInt(9999));
		if (washer == null) {
			throw new FieldIsNessasaryException("Fill in complete details");
		} else {
			washer.setRole("Washer");
			return washerRepository.save(washer);		
		}
		
	}

	@Override
	public String washerChoice(Boolean option) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> washerOrders(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
