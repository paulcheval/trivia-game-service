package com.freeloader.triviaservice.service;

import java.util.List;

import com.freeloader.triviaservice.model.TriviaItem;
import com.freeloader.triviaservice.netowrk.model.TriviaQuestionAnswer;
import com.freeloader.triviaservice.netowrk.model.TriviaQuestionAnswers;

public interface QuestionAndAnswerService {
	
	public TriviaQuestionAnswers retrieveQuestions();

}
