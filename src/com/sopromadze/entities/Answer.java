package com.sopromadze.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the answers database table.
 * 
 */
@Entity
@Table(name="answers")
@NamedQuery(name="Answer.findAll", query="SELECT a FROM Answer a")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="is_correct")
	private byte isCorrect;

	@Lob
	private String text;

	//bi-directional many-to-one association to Question
	@ManyToOne(fetch=FetchType.LAZY)
	private Question question;

	public Answer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getIsCorrect() {
		return this.isCorrect;
	}

	public void setIsCorrect(byte isCorrect) {
		this.isCorrect = isCorrect;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}