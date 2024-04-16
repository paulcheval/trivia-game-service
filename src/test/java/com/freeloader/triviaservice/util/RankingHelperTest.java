package com.freeloader.triviaservice.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.freeloader.triviaservice.entities.HighScore;
import com.freeloader.triviaservice.model.HighScoreDetail;

class RankingHelperTest {

	List<HighScore> allHighScoresList = Arrays.asList(new HighScore("Ranger Smith", 300, LocalDate.of(2023, 7, 10)),
			new HighScore("Mocha Joe", 305, LocalDate.of(2023, 9, 10)),
			new HighScore("Yogi", 300, LocalDate.of(2023, 7, 15)),
			new HighScore("BamBam", 290, LocalDate.of(2023, 7, 15)),
			new HighScore("Pebbles", 290, LocalDate.of(2023, 8, 15)),
			new HighScore("Booboo", 280, LocalDate.of(2023, 8, 1)),
			new HighScore("Ranger Smith", 300, LocalDate.of(2023, 7, 10)),
			new HighScore("Mocha Joe", 300, LocalDate.of(2023, 9, 10)),
			new HighScore("Yogi", 290, LocalDate.of(2023, 7, 15)),
			new HighScore("BamBam", 290, LocalDate.of(2023, 7, 15)),
			new HighScore("Pebbles", 290, LocalDate.of(2023, 8, 15)),
			new HighScore("Pebbles", 290, LocalDate.of(2024, 4, 15)),
			new HighScore("Booboo", 290, LocalDate.of(2023, 8, 1)));
	@Test
	void test() {
		RankingHelper rankingHelper = new RankingHelper();
		List<HighScoreDetail> rankedScores = rankingHelper.convertHighScoreToHighScoreDetail(allHighScoresList);
		System.out.println(rankedScores);
		assertEquals(13, rankedScores.size());
		HighScoreDetail topScore = rankedScores.get(0);
		
		assertEquals(1, topScore.ranking());
		assertEquals("Mocha Joe", topScore.name());
		assertEquals("2023-09-10", topScore.date());
		
		assertEquals(1, rankedScores.stream().filter(rank -> rank.ranking() == 1).collect(Collectors.counting()));
		assertEquals(4, rankedScores.stream().filter(rank -> rank.ranking() == 2).collect(Collectors.counting()));
		assertEquals(7, rankedScores.stream().filter(rank -> rank.ranking() == 3).collect(Collectors.counting()));
		assertEquals(1, rankedScores.stream().filter(rank -> rank.ranking() == 4).collect(Collectors.counting()));
	}

}
