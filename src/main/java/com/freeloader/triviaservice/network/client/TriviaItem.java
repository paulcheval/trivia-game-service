package com.freeloader.triviaservice.network.client;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freeloader.triviaservice.model.Question;

@JsonIgnoreProperties
public class TriviaItem {
	
	private String category; 
	private String correctAnswer; 
	private String difficulty; 
	private String id; 
	private List<String> incorrectAnswers; 
	private boolean isNiche; 
	private Question question; 
	private List<String> regions; 
	private List<String> tags; 
	private String type;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getIncorrectAnswers() {
		return incorrectAnswers;
	}
	public void setIncorrectAnswers(List<String> incorrectAnswers) {
		this.incorrectAnswers = incorrectAnswers;
	}
	public boolean isNiche() {
		return isNiche;
	}
	public void setNiche(boolean isNiche) {
		this.isNiche = isNiche;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public List<String> getRegions() {
		return regions;
	}
	public void setRegions(List<String> regions) {
		this.regions = regions;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "TriviaItem [category=" + category + ", correctAnswer=" + correctAnswer + ", difficulty=" + difficulty
				+ ", id=" + id + ", incorrectAnswers=" + incorrectAnswers + ", isNiche=" + isNiche + ", question="
				+ question + ", regions=" + regions + ", tags=" + tags + ", type=" + type + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, correctAnswer, difficulty, id, incorrectAnswers, isNiche, question, regions, tags,
				type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TriviaItem other = (TriviaItem) obj;
		return Objects.equals(category, other.category) && Objects.equals(correctAnswer, other.correctAnswer)
				&& Objects.equals(difficulty, other.difficulty) && Objects.equals(id, other.id)
				&& Objects.equals(incorrectAnswers, other.incorrectAnswers) && isNiche == other.isNiche
				&& Objects.equals(question, other.question) && Objects.equals(regions, other.regions)
				&& Objects.equals(tags, other.tags) && Objects.equals(type, other.type);
	}
	
}
