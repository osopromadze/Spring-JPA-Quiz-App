package com.sopromadze.utilities;

import java.util.List;

public class QuestionsJson {
	private String question;
	private List<String> options;
	private int correctIndex;
	private String correctResponse;
	private String incorrectResponse;
	
	public QuestionsJson() {
		
	}
	
	public QuestionsJson(String question, List<String> options, int correctIndex, String correctResponse,
			String incorrectResponse) {
		this.question = question;
		this.options = options;
		this.correctIndex = correctIndex;
		this.correctResponse = correctResponse;
		this.incorrectResponse = incorrectResponse;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public int getCorrectIndex() {
		return correctIndex;
	}
	public void setCorrectIndex(int correctIndex) {
		this.correctIndex = correctIndex;
	}
	public String getCorrectResponse() {
		return correctResponse;
	}
	public void setCorrectResponse(String correctResponse) {
		this.correctResponse = correctResponse;
	}
	public String getIncorrectResponse() {
		return incorrectResponse;
	}
	public void setIncorrectResponse(String incorrectResponse) {
		this.incorrectResponse = incorrectResponse;
	}
	
	
}
