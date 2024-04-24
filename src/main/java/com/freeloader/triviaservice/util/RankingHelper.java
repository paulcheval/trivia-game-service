package com.freeloader.triviaservice.util;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.freeloader.triviaservice.entities.HighScore;
import com.freeloader.triviaservice.model.HighScoreDetail;

@Component
public class RankingHelper {

	public List<HighScoreDetail> convertHighScoreToHighScoreDetail(List<HighScore> highScores) {
		return highScores.stream().sorted(Comparator.comparing(HighScore::getScore).reversed())
				.map(new Function<HighScore, HighScoreDetail>() {
					private int lastScore = -1;
					private int currentRank = 0;

					@Override
					public HighScoreDetail apply(HighScore oldObject) {
						if (oldObject.getScore() != lastScore) {
							lastScore = oldObject.getScore();
							currentRank++;
						}
						return new HighScoreDetail(oldObject.getName(), oldObject.getScore(),
								oldObject.getDate().toString(), currentRank);
					}
				}).collect(Collectors.toList());

	}

}
