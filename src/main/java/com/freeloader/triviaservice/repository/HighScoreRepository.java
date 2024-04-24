package com.freeloader.triviaservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.freeloader.triviaservice.entities.HighScore;

@Repository
public interface HighScoreRepository extends CrudRepository<HighScore, Long> {
			
	
	List<HighScore> findByNameAndScore(String name, int score);
	
	
}
