package com.freeloader.triviaservice.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.freeloader.triviaservice.entities.HighScore;
import com.freeloader.triviaservice.model.HighScoreDetail;

class HighScoreServiceImplTest {

	@Test
	void test() {
		
		List<HighScore> allHighScoresList = new ArrayList<HighScore>();
		allHighScoresList.add(new HighScore("Ranger Smith", 3000, LocalDate.of(2023, 7, 10)));
		allHighScoresList.add(new HighScore("Mocha Joe", 3000, LocalDate.of(2023, 9, 10)));
		allHighScoresList.add(new HighScore("Yogi", 290, LocalDate.of(2023, 7, 15)));
		allHighScoresList.add(new HighScore("BamBam", 290, LocalDate.of(2023, 7, 15)));
		allHighScoresList.add(new HighScore("Pebbles", 290, LocalDate.of(2023, 8, 15)));
		allHighScoresList.add(new HighScore("Booboo", 280, LocalDate.of(2023, 8, 1)));
		
		
		Map<Integer, List<HighScore>> mapOfScores = 
				allHighScoresList.stream().collect(Collectors.groupingBy(score -> score.getScore()));
        
		List<HighScoreDetail> newObjects = IntStream.range(0, allHighScoresList.size())
                .mapToObj(i -> {
                	HighScore oldObj = allHighScoresList.get(i);
                    int rank = (int) allHighScoresList.stream()
                            .mapToInt(HighScore::getScore)
                            .distinct()
                            .sorted()
                            .mapToObj(Integer::valueOf)
                            .collect(Collectors.toList())
                            .indexOf(oldObj.getScore()) + 1;

                    return new HighScoreDetail(oldObj.getName(), oldObj.getScore(), oldObj.getDate().toString(), rank);
                })
                .collect(Collectors.toList());

        newObjects.forEach(System.out::println);
        System.out.println("Break");
        List<HighScoreDetail> newObjects2 = allHighScoresList.stream()
                .sorted((o1, o2) -> Integer.compare(o2.getScore(), o1.getScore())) // Sort by score descending
                .map(o -> {
                    int rank = allHighScoresList.indexOf(o) + 1; // Index starts from 0, so add 1 for ranking
                    return new HighScoreDetail(o.getName(),o.getScore(), o.getDate().toString(),  rank);
                })
                .collect(Collectors.toList());

        newObjects2.forEach(System.out::println);
        System.out.println("Break");
        List<HighScoreDetail> newObjects3 = allHighScoresList.stream()
        	    .sorted(Comparator.comparing(HighScore::getScore).reversed())
        	    .map(new Function<HighScore, HighScoreDetail>() {
        	        private int lastScore = -1;
        	        private int currentRank = 0;

        	        @Override
        	        public HighScoreDetail apply(HighScore oldObject) {
        	            if (oldObject.getScore() != lastScore) {
        	                lastScore = oldObject.getScore();
        	                currentRank++;
        	            }
        	            return new HighScoreDetail(oldObject.getName(), oldObject.getScore(), oldObject.getDate().toString(),  currentRank);
        	        }
        	    })
        	    .collect(Collectors.toList());
        newObjects3.forEach(System.out::println);
        
		System.out.println(mapOfScores);
	}

}
