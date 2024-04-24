package com.freeloader.triviaservice.service;

import java.util.List;

import com.freeloader.triviaservice.model.TriviaQuestionAnswer;
import com.freeloader.triviaservice.model.TriviaQuestionAnswers;
import com.freeloader.triviaservice.network.client.TriviaItem;

public interface QuestionAndAnswerService {
	
	public TriviaQuestionAnswers retrieveQuestions();

}
