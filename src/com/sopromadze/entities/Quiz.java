package com.sopromadze.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Length;

import java.util.List;


@Entity
@Table(name="quizs")
@NamedQuery(name="Quiz.findAll", query="SELECT q FROM Quiz q")
public class Quiz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="image_url")
	private String imageUrl;

	@Length(min = 5, max = 50, message = "Quiz name must be minimum 5 and maximum 50 characters")
	private String name;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="quiz")
	@Cascade(value = {CascadeType.ALL})
	private List<Question> questions;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="quiz")
	private List<Result> results;

	public Quiz() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setQuiz(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setQuiz(null);

		return question;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setQuiz(this);

		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setQuiz(null);

		return result;
	}

}