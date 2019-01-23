package com.sopromadze.dao;

import java.util.List;

import com.sopromadze.entities.Quiz;

public interface QuizDao {

	void saveQuiz(Quiz quiz);

	List<Quiz> getAllQuizzes();

	Quiz getQuiz(int id);

	Quiz updateQuiz(Quiz quiz);

	void deleteQuiz(Quiz quiz);

}