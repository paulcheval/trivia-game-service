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
	private int score;
	private LocalDate date;

	
	protected HighScore() {}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	public HighScore(String name, int score, LocalDate date) {
		super();
		this.name = name;
		this.score = score;
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, date, name, score);
	}

	@Override
	public String toString() {
		return "HighScore [id=" + id + ", name=" + name + ", score=" + score + ", date=" + date + "]";
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
		return Objects.equals(date, other.date) && Objects.equals(name, other.name)
				&& Objects.equals(score, other.score);
	}	
	
}
