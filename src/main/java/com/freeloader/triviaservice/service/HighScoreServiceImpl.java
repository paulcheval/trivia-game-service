package com.freeloader.triviaservice.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.freeloader.triviaservice.entities.HighScore;
import com.freeloader.triviaservice.model.HighScoreRequest;
import com.freeloader.triviaservice.model.HighScoreResponse;
import com.freeloader.triviaservice.repository.HighScoreRepository;
import com.freeloader.triviaservice.util.RankingHelper;

@Service
public class HighScoreServiceImpl implements HighScoreService {

	private HighScoreRepository repository;
	private RankingHelper objectConversion;

	public HighScoreServiceImpl(HighScoreRepository repository, RankingHelper objectConversion) {
		this.repository = repository;
		this.objectConversion = objectConversion;
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

		return new HighScoreResponse(objectConversion.convertHighScoreToHighScoreDetail(allHighScoresList));
	}

	@Override
	public void addHighScore(HighScoreRequest highScoreRequest) {
		repository.save(new HighScore(highScoreRequest.name(), highScoreRequest.score(),
				convertStringDateToLocalDate(highScoreRequest)));
	}

	private LocalDate convertStringDateToLocalDate(HighScoreRequest highScoreRequest) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(highScoreRequest.date(), formatter);
		return localDate;
	}

}
