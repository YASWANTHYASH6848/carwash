package com.admin.service;

import java.util.List;

import com.admin.models.Customer;
import com.admin.models.WashPacks;
import com.admin.models.Washer;
import com.admin.models.WasherLeaderboard;

public interface AdminService {

	public WashPacks addNewWashPack(WashPacks pack);
	
	public WashPacks findByName(String name);
	
	public WashPacks findWashpacksById(int packId);
	
	public WashPacks editWashPack(WashPacks washPacks, int packId);
	
	public List<WasherLeaderboard> washerLeaderboard();
	
	public WasherLeaderboard addToLeaderboard(WasherLeaderboard leaderboard);
		
	public void deleteWashpackById(int id);
	
    public List<Customer> listOfCustomers();

    public List<Washer> listOfWashers();

	
}
