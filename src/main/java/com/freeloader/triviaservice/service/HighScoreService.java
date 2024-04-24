package com.freeloader.triviaservice.service;

import java.util.List;

import com.freeloader.triviaservice.model.HighScoreRequest;
import com.freeloader.triviaservice.model.HighScoreResponse;
import com.freeloader.triviaservice.netowrk.model.TriviaQuestionAnswer;

public interface HighScoreService {
	public HighScoreResponse getAllHighScores();
	
	public void addHighScore(HighScoreRequest highScoreRequest) throws Exception;

}
