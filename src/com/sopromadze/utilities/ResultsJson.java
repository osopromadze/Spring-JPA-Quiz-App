package com.sopromadze.utilities;

public class ResultsJson {
	private Long timeNow;
	private int quizId;
	private String username;
	private int correctAnswers;
	private int incorrectAnswers;

	public Long getTimeNow() {
		return timeNow;
	}

	public void setTimeNow(Long timeNow) {
		this.timeNow = timeNow;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public int getIncorrectAnswers() {
		return incorrectAnswers;
	}

	public void setIncorrectAnswers(int incorrectAnswers) {
		this.incorrectAnswers = incorrectAnswers;
	}

}
