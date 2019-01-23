package com.sopromadze.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopromadze.dao.QuizDao;
import com.sopromadze.entities.Quiz;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizDao quizDao;
	
	@Override
	public void saveQuiz(Quiz quiz) {
		quizDao.saveQuiz(quiz);
	}
	
	@Override
	public List<Quiz> getAllQuizzes(){
		return quizDao.getAllQuizzes();
	}
	
	@Override
	public Quiz getQuiz(int quizId) {
		return quizDao.getQuiz(quizId);
	}
	
	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return quizDao.updateQuiz(quiz);
	}
	
	@Override
	public void deleteQuiz(int quizId) {
		Quiz quiz = quizDao.getQuiz(quizId);
		quizDao.deleteQuiz(quiz);
	}
}
