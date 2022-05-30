package com.admin.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.admin.models.Customer;
import com.admin.models.WashPacks;
import com.admin.models.Washer;
import com.admin.models.WasherLeaderboard;
import com.admin.repo.AdminRepository;
import com.admin.repo.WasherLeaderboardRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private WasherLeaderboardRepository washerLeaderboardRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public WashPacks addNewWashPack(WashPacks pack) {
		Random random = new Random();
		WashPacks washPacks = new WashPacks();
		washPacks.setPackname(pack.getPackname());
		washPacks.setAmount(pack.getAmount());
		washPacks.setDescription(pack.getDescription());
		washPacks.setPackId(random.nextInt(9999));

		adminRepository.save(washPacks);

		return washPacks;
	}

	@Override
	public WashPacks findByName(String name) {
		return adminRepository.findAll().stream().filter(p -> p.getPackname().contains(name)).findAny().orElse(null);
	}

	@Override
	public WashPacks findWashpacksById(int packId) {
		return adminRepository.findById(packId).orElse(null);
	}

	@Override
	public List<WasherLeaderboard> washerLeaderboard() {
		return washerLeaderboardRepository.findAll();
	}

	public WasherLeaderboard addNewWasherToLeaderboard(WasherLeaderboard washerLeaderboard) {
		WasherLeaderboard washerLeaderboard2 = new WasherLeaderboard();
		washerLeaderboard2.setWasherName(washerLeaderboard.getWasherName());
		washerLeaderboard2.setWaterSavedInliters(washerLeaderboard.getWaterSavedInliters());
		return washerLeaderboardRepository.save(washerLeaderboard2);
	}

	@Override
	public void deleteWashpackById(int id) {
		WashPacks washpacks = new WashPacks();
		adminRepository.deleteById(id);
	}

	@Override
	public WashPacks editWashPack(WashPacks washPacks, int packId) {
		WashPacks existingPack = adminRepository.findById(packId).orElse(null);
		existingPack.setPackname(washPacks.getPackname());
		existingPack.setAmount(washPacks.getAmount());
		existingPack.setDescription(washPacks.getDescription());

		adminRepository.save(existingPack);
		return existingPack;
	}

//	@HystrixCommand(fallbackMethod = "fallbackListOfCustomer")
	@Override
	public List<Customer> listOfCustomers() {

		ResponseEntity<List<Customer>> reponse = restTemplate.exchange(
				"http://customer-microservice/customer/get-all-customer", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {
				});
		List<Customer> customersList = reponse.getBody();

		return customersList;
	}

//	public List<Customer> fallbackListOfCustomer() {
//		return (List<Customer>) new Customer(0, "Customer Not Found", "", "", "", "", "");
//	}

//	@HystrixCommand(fallbackMethod = "fallbackListOfWasher")
	@Override
	public List<Washer> listOfWashers() {
		ResponseEntity<List<Washer>> washerResponse = restTemplate.exchange(
				"http://washer-microservice/washer/get-all-washer", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Washer>>() {
				});
		List<Washer> washerList = washerResponse.getBody();
		return washerList;
	}
//
//	public List<Washer> fallbackListOfWasher() {
//		return (List<Washer>) new Washer(0, "Washer Not Found", "", "", "", "");
//	}

	@Override
	public WasherLeaderboard addToLeaderboard(WasherLeaderboard leaderboard) {
		WasherLeaderboard leaderboard2 = new WasherLeaderboard();
		leaderboard2.setRank(leaderboard.getRank());
		leaderboard2.setWasherName(leaderboard.getWasherName());
		leaderboard2.setWaterSavedInliters(leaderboard.getWaterSavedInliters());
		washerLeaderboardRepository.save(leaderboard2);
		return leaderboard2;
	}


}
