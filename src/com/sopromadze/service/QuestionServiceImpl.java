package com.sopromadze.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopromadze.dao.QuestionDao;
import com.sopromadze.entities.Question;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public Question saveQuestion(Question question) {
		return questionDao.saveQuestion(question);
	}
	
	@Override
	public Question getQuestion(int id) {
		return questionDao.getQuestion(id);
	}
	
	@Override
	public Question updateQuestion(Question question) {
		return questionDao.updateQuestion(question);
	}
	
	@Override
	public void deleteQuestion(int id) {
		Question question = questionDao.getQuestion(id);
		questionDao.deleteQuestion(question);
	}
}
