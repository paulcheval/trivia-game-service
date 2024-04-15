package com.freeloader.triviaservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freeloader.triviaservice.model.HighScoreResponse;

@RequestMapping("/trivia-high-score")
public interface HighScoreController {
	
	@GetMapping("/scores")
	public ResponseEntity<HighScoreResponse> retrieveHighScores();

}
