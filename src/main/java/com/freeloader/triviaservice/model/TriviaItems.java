package com.freeloader.triviaservice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class TriviaItems {
	
	
	private List<TriviaItem> triviaItems;

	public List<TriviaItem> getTriviaItems() {
		return triviaItems;
	}

	public void setTriviaItems(List<TriviaItem> triviaItems) {
		this.triviaItems = triviaItems;
	}
	
	public TriviaItems() {
		triviaItems = new ArrayList<>();
	}

	public TriviaItems(List<TriviaItem> triviaItems) {
		super();
		this.triviaItems = triviaItems;
	}

	@Override
	public String toString() {
		return "TriviaItems [triviaItems=" + triviaItems + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(triviaItems);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TriviaItems other = (TriviaItems) obj;
		return Objects.equals(triviaItems, other.triviaItems);
	}

}
