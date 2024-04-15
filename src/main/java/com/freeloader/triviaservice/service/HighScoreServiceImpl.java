package com.freeloader.triviaservice.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.freeloader.triviaservice.entities.HighScore;
import com.freeloader.triviaservice.model.HighScoreDetail;
import com.freeloader.triviaservice.model.HighScoreResponse;
import com.freeloader.triviaservice.repository.HighScoreRepository;

@Service
public class HighScoreServiceImpl implements HighScoreService {
	
	private HighScoreRepository repository;
	

	public HighScoreServiceImpl(HighScoreRepository repository) {		
		this.repository = repository;
	}


	@Override
	public HighScoreResponse getAllHighScores() {
		List<HighScore> allHighScoresList = new ArrayList<HighScore>();

		Iterable<HighScore> allHighScores = repository.findAll();
		if (allHighScores == null) {
			throw new RuntimeException("No high scores found");
		}

		allHighScores.forEach(score -> {
			allHighScoresList.add(score);
		});

		List<HighScoreDetail> sortedHighScores = allHighScoresList.stream()
				.sorted(Comparator.comparing(HighScore::getRanking))
				.map(score -> new HighScoreDetail(score.getName(), score.getScore(), score.getDate().toString(), score.getRanking()))
				.collect(Collectors.toList());
		return new HighScoreResponse(sortedHighScores);
	}
		

}
