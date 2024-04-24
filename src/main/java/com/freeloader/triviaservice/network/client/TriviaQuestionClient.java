package com.freeloader.triviaservice.network.client;

import java.util.List;

import com.freeloader.triviaservice.model.TriviaItem;
import com.freeloader.triviaservice.netowrk.model.TriviaQuestionAnswer;

public interface TriviaQuestionClient {
	
	public List<TriviaItem> getTriviaQuestions();

}
