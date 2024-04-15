package com.freeloader.triviaservice.entities;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties
@Table(name="HIGH_SCORES")
public class HighScore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private Long score;
	private LocalDate date;
	private int ranking;
	
	protected HighScore() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	public HighScore(String name, Long score, LocalDate date, int ranking) {
		super();
		this.name = name;
		this.score = score;
		this.date = date;
		this.ranking = ranking;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, date, name, ranking, score);
	}
	
	@Override
	public String toString() {
		return "HighScores [id=" + id + ", name=" + name + ", score=" + score + ", date=" + date + ", ranking="
				+ ranking + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HighScore other = (HighScore) obj;
		return Objects.equals(date, other.date) && Objects.equals(name, other.name) && ranking == other.ranking
				&& Objects.equals(score, other.score);
	}	
	
}
