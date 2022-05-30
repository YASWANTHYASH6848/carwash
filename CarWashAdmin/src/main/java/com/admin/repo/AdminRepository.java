package com.admin.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.admin.models.WashPacks;

public interface AdminRepository extends MongoRepository<WashPacks, Integer>{

}
