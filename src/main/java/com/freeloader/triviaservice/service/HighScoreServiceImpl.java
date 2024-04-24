package com.freeloader.triviaservice.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.freeloader.triviaservice.entities.HighScore;
import com.freeloader.triviaservice.exception.HighScoreNotConsideredForAdding;
import com.freeloader.triviaservice.model.HighScoreDetail;
import com.freeloader.triviaservice.model.HighScoreRequest;
import com.freeloader.triviaservice.model.HighScoreResponse;
import com.freeloader.triviaservice.repository.HighScoreRepository;
import com.freeloader.triviaservice.util.RankingHelper;
import com.freeloader.triviaservice.util.TriviaGameConstants;

@Service
public class HighScoreServiceImpl implements HighScoreService {
	private static final Logger log = LoggerFactory.getLogger(HighScoreServiceImpl.class);

	private HighScoreRepository repository;
	private RankingHelper objectConversion;

	public HighScoreServiceImpl(HighScoreRepository repository, RankingHelper objectConversion) {
		this.repository = repository;
		this.objectConversion = objectConversion;
	}

	@Override
	public HighScoreResponse getAllHighScores() {
		return new HighScoreResponse(
				objectConversion.convertHighScoreToHighScoreDetail(retrieveHighScoresFromRepository()));
	}

	@Override
	public void addHighScore(HighScoreRequest highScoreRequest) throws Exception {
		if (isNewHighScoreTooLowToConsider(highScoreRequest)) {
			throw new HighScoreNotConsideredForAdding();
		}

		addNewHighScore(highScoreRequest);
		cleanUpLowScores(determineLowScoresByRanking());
	}

	private boolean isNewHighScoreTooLowToConsider(HighScoreRequest highScoreRequest) {
		int determineMinScoreInDB = determineMinScoreInDB();
		return highScoreRequest.score() < determineMinScoreInDB;
	}

	private int determineMinScoreInDB() {
		return retrieveHighScoresFromRepository().stream().sorted(Comparator.comparing(HighScore::getScore))
				.collect(Collectors.toList()).get(0).getScore();
	}

	private void addNewHighScore(HighScoreRequest highScoreRequest) {
		repository.save(new HighScore(highScoreRequest.name(), highScoreRequest.score(),
				convertStringDateToLocalDate(highScoreRequest)));
	}

	private List<HighScoreDetail> determineLowScoresByRanking() {
		return getAllHighScores().highScores().stream()
				.filter(score -> score.ranking() > TriviaGameConstants.LOWEST_RANKING_ALLOWED)
				.collect(Collectors.toList());
	}

	private void cleanUpLowScores(List<HighScoreDetail> lowScores) {
		List<Long> idsToDelete = new ArrayList<>();

		lowScores.forEach(score -> {
			repository.findByNameAndScore(score.name(), score.score()).forEach(lowScore -> {
				idsToDelete.add(lowScore.getId());
			});
		});

		idsToDelete.forEach(id -> {
			log.info("Deleting entries with low score with name: " + repository.findById(id).get().getName()
					+ " and score: " + repository.findById(id).get().getScore());
			repository.deleteById(id);
		});

	}

	private List<HighScore> retrieveHighScoresFromRepository() {
		List<HighScore> allHighScoresList = new ArrayList<HighScore>();

		Iterable<HighScore> allHighScores = repository.findAll();
		if (allHighScores == null) {
			throw new RuntimeException("No high scores found");
		}

		allHighScores.forEach(score -> {
			allHighScoresList.add(score);
		});
		return allHighScoresList;
	}

	private LocalDate convertStringDateToLocalDate(HighScoreRequest highScoreRequest) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(highScoreRequest.date(), formatter);
		return localDate;
	}

}
