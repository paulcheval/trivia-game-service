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
		repository.save(new HighScore("Ranger Smith", 300, LocalDate.of(2023, 7, 10)));
		repository.save(new HighScore("Yogi", 300, LocalDate.of(2023, 7, 15)));
		repository.save(new HighScore("Booboo", 280, LocalDate.of(2023, 8, 1)));
		repository.save(new HighScore("Cindi", 270, LocalDate.of(2023, 7, 10)));
		repository.save(new HighScore("Penelope PitStop", 260, LocalDate.of(2023, 7, 15)));
		repository.save(new HighScore("Snagle Puss", 250, LocalDate.of(2023, 7, 15)));
		repository.save(new HighScore("Quick Draw McGraw", 240, LocalDate.of(2023, 7, 14)));
		repository.save(new HighScore("Huckleberry Hound", 240, LocalDate.of(2023, 7, 10)));
		repository.save(new HighScore("Augie Doggie", 220, LocalDate.of(2023, 7, 1)));
		repository.save(new HighScore("Doggie Daddy", 220, LocalDate.of(2024, 1, 15)));
		repository.save(new HighScore("Pixie", 200, LocalDate.of(2024, 1, 10)));
		repository.save(new HighScore("Dixie", 190, LocalDate.of(2024, 1, 15)));
		repository.save(new HighScore("Jinks", 180, LocalDate.of(2024, 1, 1)));
		repository.save(new HighScore("Boots", 170, LocalDate.of(2023, 12, 15)));
		repository.save(new HighScore("Snooper", 150, LocalDate.of(2023, 12, 10)));
		repository.save(new HighScore("Blabber", 150, LocalDate.of(2023, 12, 1)));
		repository.save(new HighScore("Top Cat", 140, LocalDate.of(2023, 11, 15)));
		repository.save(new HighScore("Benny", 130, LocalDate.of(2023, 10, 10)));
		repository.save(new HighScore("Choo Choo", 110, LocalDate.of(2023, 9, 1)));
		repository.save(new HighScore("Brain", 110, LocalDate.of(2023, 7, 15)));

		log.info("High Scroes loaded are");
		Iterable<HighScore> allScores = repository.findAll();
		allScores.forEach(conversion -> {
			log.info(conversion.toString());
		});
	}

}
