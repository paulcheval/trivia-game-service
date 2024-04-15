package com.freeloader.triviaservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.freeloader.triviaservice.model.HighScoreResponse;
import com.freeloader.triviaservice.service.HighScoreService;

@RestController
@CrossOrigin
public class HighScoreControllerImpl implements HighScoreController {
	private static final Logger log = LoggerFactory.getLogger(HighScoreControllerImpl.class);
	

	private HighScoreService service;
	
	public HighScoreControllerImpl(HighScoreService service) {
		super();
		this.service = service;
	}

	@Override
	public ResponseEntity<HighScoreResponse> retrieveHighScores() {
		log.info("High Score Service Being called with");
		HighScoreResponse response;
		try {
			response = service.getAllHighScores();
		
		} catch (Exception e) {
			return  new ResponseEntity<HighScoreResponse>(HttpStatus.NOT_FOUND);
		}
		log.info("The high scores are response: " + response.toString());
		return new ResponseEntity<HighScoreResponse>(response, HttpStatus.OK);	
	}

}
