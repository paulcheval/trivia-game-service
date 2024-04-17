package com.freeloader.triviaservice.service;

import com.freeloader.triviaservice.model.HighScoreRequest;
import com.freeloader.triviaservice.model.HighScoreResponse;

public interface HighScoreService {
	public HighScoreResponse getAllHighScores();
	
	public void addHighScore(HighScoreRequest highScoreRequest);
}
