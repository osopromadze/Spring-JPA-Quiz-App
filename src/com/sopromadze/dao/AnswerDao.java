package com.sopromadze.dao;

import com.sopromadze.entities.Answer;

public interface AnswerDao {

	void saveAnswer(Answer answer);

	Answer updateAnswer(Answer answer);

}