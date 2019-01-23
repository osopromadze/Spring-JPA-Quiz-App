package com.sopromadze.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopromadze.dao.AnswerDao;
import com.sopromadze.entities.Answer;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	private AnswerDao answerDao;
	
	@Override
	public void saveAnswer(Answer answer) {
		answerDao.saveAnswer(answer);
	}
	
	@Override
	public Answer updateAnswer(Answer answer) {
		return answerDao.updateAnswer(answer);
	}
}
