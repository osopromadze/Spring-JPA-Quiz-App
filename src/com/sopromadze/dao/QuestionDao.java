package com.sopromadze.dao;

import com.sopromadze.entities.Question;

public interface QuestionDao {

	Question saveQuestion(Question question);

	Question getQuestion(int id);

	Question updateQuestion(Question question);

	void deleteQuestion(Question question);

}