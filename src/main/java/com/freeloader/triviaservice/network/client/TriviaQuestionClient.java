package com.freeloader.triviaservice.network.client;

import java.util.List;

import com.freeloader.triviaservice.model.TriviaQuestionAnswer;

public interface TriviaQuestionClient {
	
	public List<TriviaItem> getTriviaQuestions();

}
