	package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.models.Customer;
import com.admin.models.WashPacks;
import com.admin.models.Washer;
import com.admin.models.WasherLeaderboard;
import com.admin.repo.AdminRepository;
import com.admin.service.AdminServiceImpl;
import com.netflix.discovery.converters.Auto;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@Autowired
	private AdminRepository adminRepository;
	
	
//	Method to add washpack
	@PostMapping("/add-pack")
	public WashPacks addNewPack(@RequestBody WashPacks packs)	{
		return adminServiceImpl.addNewWashPack(packs);
	}
	
	
//	Method to get washpack by name
	@GetMapping("/get-pack/{name}")
	public WashPacks pack(@PathVariable("name") String name)	{
		return adminServiceImpl.findByName(name);
	}
	
	
//	Method to get washpack by id
	@GetMapping("{packId}")
	public ResponseEntity<WashPacks> getCarById(@PathVariable("packId") int packId) {
		return new ResponseEntity<WashPacks>(adminServiceImpl.findWashpacksById(packId),HttpStatus.OK);
	}
	
	
//	Method to get all washpacks
	@GetMapping("/all-packs")
	public ResponseEntity<List<WashPacks>> allPacks(){
		return new ResponseEntity<>(adminRepository.findAll(), HttpStatus.OK);
	}
	
//	Method to edit washpack by id
	@PutMapping("/edit-pack/{packId}")
	public ResponseEntity<WashPacks> updateWashpacks(@PathVariable("packId") int packId, @RequestBody WashPacks washPacks){
		return new ResponseEntity<>(adminServiceImpl.editWashPack(washPacks, packId), HttpStatus.OK);
	}
	
	
//	Deleting washpack by id
	@DeleteMapping("/delete/{packId}")
    public void deleteById(@PathVariable("packId") int packId) {
        this.adminServiceImpl.deleteWashpackById(packId);
    }
	
	
//	Method to load all the customers
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> listOfCustomers() {
        return new ResponseEntity<>(adminServiceImpl.listOfCustomers(), HttpStatus.OK);
    }

//    Method to load all the washers
    @GetMapping("/washers")
    public ResponseEntity<List<Washer>> listOfWashers() {
        return new ResponseEntity<>(adminServiceImpl.listOfWashers(), HttpStatus.OK);
    }
	
//  Method to display the leaderboard
	@GetMapping("/leaderboard")
	public List<WasherLeaderboard> washerLeaderboard(){
		return adminServiceImpl.washerLeaderboard();
	}
	
//	Method to add washpack
	@PostMapping("/add-leaderboard")
	public WasherLeaderboard addToLeaderBoard(@RequestBody WasherLeaderboard washerLeaderboard)	{
		return adminServiceImpl.addToLeaderboard(washerLeaderboard);
	}
	
}
