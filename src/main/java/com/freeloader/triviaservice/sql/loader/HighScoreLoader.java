package com.freeloader.triviaservice.sql.loader;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

import com.freeloader.triviaservice.entities.HighScore;
import com.freeloader.triviaservice.repository.HighScoreRepository;



@Component
public class HighScoreLoader implements SmartInitializingSingleton {
	
	private static final Logger log = LoggerFactory.getLogger(HighScoreLoader.class);

	private final HighScoreRepository repository;
	
	public HighScoreLoader(HighScoreRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void afterSingletonsInstantiated() {
		repository.save(new HighScore("Ranger Smith", 3000L, LocalDate.of(2023, 7, 10), 1));
		repository.save(new HighScore("Yogi", 290L, LocalDate.of(2023, 7, 15), 2));
		repository.save(new HighScore("Booboo", 280L, LocalDate.of(2023, 8, 1), 3));
		repository.save(new HighScore("Cindi", 270L, LocalDate.of(2023, 7, 10), 4));
		repository.save(new HighScore("Penelope PitStop", 260L, LocalDate.of(2023, 7, 15), 5));
		repository.save(new HighScore("Snagle Puss", 250L, LocalDate.of(2023, 7, 15), 6));
		repository.save(new HighScore("Quick Draw McGraw", 240L, LocalDate.of(2023, 7, 14), 7));
		repository.save(new HighScore("Huckleberry Hound", 230L, LocalDate.of(2023, 7, 10), 8));
		repository.save(new HighScore("Augie Doggie", 220L, LocalDate.of(2023, 7, 1), 9));
		repository.save(new HighScore("Doggie Daddy", 210L, LocalDate.of(2024, 1, 15), 10));
		repository.save(new HighScore("Pixie", 200L, LocalDate.of(2024, 1, 10), 11));
		repository.save(new HighScore("Dixie", 190L, LocalDate.of(2024, 1, 15), 12));
		repository.save(new HighScore("Jinks", 180L, LocalDate.of(2024, 1, 1), 13));
		repository.save(new HighScore("Boots", 170L, LocalDate.of(2023, 12, 15), 14));
		repository.save(new HighScore("Snooper", 160L, LocalDate.of(2023, 12, 10), 15));
		repository.save(new HighScore("Blabber", 150L, LocalDate.of(2023, 12, 1), 16));
		repository.save(new HighScore("Top Cat", 140L, LocalDate.of(2023, 11, 15), 17));
		repository.save(new HighScore("Benny", 130L, LocalDate.of(2023, 10, 10), 18));
		repository.save(new HighScore("Choo Choo", 120L, LocalDate.of(2023, 9, 1), 19));
		repository.save(new HighScore("Brain", 110L, LocalDate.of(2023, 7, 15), 20));

		log.info("High Scroes loaded are");
		repository.findAll().forEach(conversion -> {
			log.info(conversion.toString());
		});
	}

}
