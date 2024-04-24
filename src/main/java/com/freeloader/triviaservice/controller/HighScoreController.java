package com.freeloader.triviaservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freeloader.triviaservice.model.HighScoreRequest;
import com.freeloader.triviaservice.model.HighScoreResponse;
import com.freeloader.triviaservice.netowrk.model.TriviaQuestionAnswer;
import com.freeloader.triviaservice.netowrk.model.TriviaQuestionAnswers;

@RequestMapping("/trivia-high-score")
public interface HighScoreController {
	
	@GetMapping("/scores")
	public ResponseEntity<HighScoreResponse> retrieveHighScores();
	
	@PostMapping("/highscore")
	public ResponseEntity<String> addHighScore(HighScoreRequest highScoreRequest);
	
	@GetMapping("/questions")
	public ResponseEntity<TriviaQuestionAnswers> retrieveQuestions();

}
