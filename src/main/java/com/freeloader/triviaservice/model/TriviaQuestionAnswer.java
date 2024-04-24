package com.freeloader.triviaservice.model;

import java.util.List;

public record TriviaQuestionAnswer(String category, String correctAnswer, String difficulty, String id, List<String> incorrectAnswers, Question question) {

}
