package com.freeloader.triviaservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.freeloader.triviaservice.model.TriviaQuestionAnswer;
import com.freeloader.triviaservice.model.TriviaQuestionAnswers;
import com.freeloader.triviaservice.network.client.TriviaItem;
import com.freeloader.triviaservice.network.client.TriviaQuestionClient;

@Service
public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {

	private TriviaQuestionClient triviaQuestionClient;

	public QuestionAndAnswerServiceImpl(TriviaQuestionClient triviaQuestionClient) {
		this.triviaQuestionClient = triviaQuestionClient;
	}

	@Override
	public TriviaQuestionAnswers retrieveQuestions() {
		List<TriviaItem> triviaQuestionsFromNetwork = triviaQuestionClient.getTriviaQuestions();
		if (!areQuestionsRetrurned(triviaQuestionsFromNetwork)) {
			return new TriviaQuestionAnswers(new ArrayList<TriviaQuestionAnswer>());
		}
		return new TriviaQuestionAnswers(convertToTriviaQuestionAnswer(triviaQuestionsFromNetwork));

	}

	private List<TriviaQuestionAnswer> convertToTriviaQuestionAnswer(List<TriviaItem> triviaQuestionsFromNetwork) {
		List<TriviaQuestionAnswer> triviaQuestionAnswers = new ArrayList<>();
		triviaQuestionsFromNetwork.forEach(triviaItem -> {
			triviaQuestionAnswers.add(new TriviaQuestionAnswer(triviaItem.getCategory(), triviaItem.getCorrectAnswer(),
					triviaItem.getDifficulty(), triviaItem.getId(), triviaItem.getIncorrectAnswers(),
					triviaItem.getQuestion()));
		});

		return triviaQuestionAnswers;
	}

	private boolean areQuestionsRetrurned(List<TriviaItem> triviaQuestionsFromNetwork) {
		if (triviaQuestionsFromNetwork == null) { return false; }
		if (triviaQuestionsFromNetwork.isEmpty()) { return false; }
		return true;
	}

}
