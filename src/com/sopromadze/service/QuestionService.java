package com.sopromadze.service;

import com.sopromadze.entities.Question;

public interface QuestionService {

	Question saveQuestion(Question question);

	Question getQuestion(int id);

	Question updateQuestion(Question question);

	void deleteQuestion(int id);

}