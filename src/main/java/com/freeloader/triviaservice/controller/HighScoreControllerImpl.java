package com.freeloader.triviaservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.freeloader.triviaservice.model.HighScoreRequest;
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

	@Override
	public ResponseEntity<Void> addHighScore(@RequestBody HighScoreRequest highScoreRequest) {
		log.info("Add High Score Service Being called with: " + highScoreRequest.toString());
		try {	
			validateHighScore(highScoreRequest);
			service.addHighScore(highScoreRequest);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("High Score Added " + highScoreRequest.toString() + " successfully.");
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	private void validateHighScore(HighScoreRequest highScoreRequest) throws IllegalArgumentException {
		if (highScoreRequest == null) {
			throw new IllegalArgumentException("High Score Request cannot be null");
		}
		
		if (highScoreRequest.name() == null || highScoreRequest.name().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		}
			
		if (highScoreRequest.date() == null || highScoreRequest.date().isEmpty()) {
			throw new IllegalArgumentException("Date cannot be null or empty");
		}
		
	}

}
