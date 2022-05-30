package com.washer.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.washer.models.Washer;

@Repository
public interface WasherRepository extends MongoRepository<Washer, Integer>{
	
	public List<Washer> findAll();
	
    public Washer findById(int id);
	
	public Washer findByName(String name);
	
}
