package com.freeloader.triviaservice.util;

public interface TriviaGameConstants {
	public static final String HIGH_SCORES = "/highscores";
	public static final String HIGH_SCORES_BY_NAME = "/highscores/{name}";
	public static final String HIGH_SCORES_BY_NAME_AND_SCORE = "/highscores/{name}/{score}";
	public static final String TRIVIA_SOURCE_BASE_URL = "https://the-trivia-api.com/v2";
	public static final String TRIVIA_SOURCE_SERVICE_URL = "/questions";
	public static final int LOWEST_RANKING_ALLOWED 	= 10;

}
