package com.admin.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.admin.models.WasherLeaderboard;

public interface WasherLeaderboardRepository extends MongoRepository<WasherLeaderboard, Integer>{
}
