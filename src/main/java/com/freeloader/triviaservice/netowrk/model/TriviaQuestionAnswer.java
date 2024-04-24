package com.freeloader.triviaservice.netowrk.model;

import java.util.List;

import com.freeloader.triviaservice.model.Question;

public record TriviaQuestionAnswer(String category, String correctAnswer, String difficulty, String id, List<String> incorrectAnswers, Question question) {

}
