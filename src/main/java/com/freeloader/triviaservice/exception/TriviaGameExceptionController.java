package com.freeloader.triviaservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class TriviaGameExceptionController {
	@ExceptionHandler(value = HighScoreNotConsideredForAdding.class)
	public ResponseEntity<Object> exception(HighScoreNotConsideredForAdding exception) {
		return new ResponseEntity<Object>("The score is not high enough to be considered for adding", HttpStatus.BAD_REQUEST);
	}

}
