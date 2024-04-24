package com.freeloader.triviaservice.network.client;

import static com.freeloader.triviaservice.util.TriviaGameConstants.TRIVIA_SOURCE_BASE_URL;
import static com.freeloader.triviaservice.util.TriviaGameConstants.TRIVIA_SOURCE_SERVICE_URL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.freeloader.triviaservice.model.TriviaItem;

@Component
public class TriviaQuestionClientImpl  implements TriviaQuestionClient{
	
	private static final Logger log = LoggerFactory.getLogger(TriviaQuestionClientImpl.class);


	RestTemplate template = new RestTemplate();

	@Override
	public List<TriviaItem> getTriviaQuestions() {
		try {
			String serviceUrl = TRIVIA_SOURCE_BASE_URL + TRIVIA_SOURCE_SERVICE_URL;
			log.info("Makeing request to "	+ serviceUrl + " to retrieve trivia questions");
			ResponseEntity<TriviaItem[]> questionsFromNetwork = template.getForEntity(serviceUrl, TriviaItem[].class);
			log.info("Response Status from Trivia URL: " + questionsFromNetwork.getStatusCode().toString());
			TriviaItem[] response = questionsFromNetwork.getBody();
			List<TriviaItem> triviaItems = Arrays.asList(response);
			log.info("Response Status from Trivia URL: " + triviaItems.toString());
			return triviaItems;

		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

}
