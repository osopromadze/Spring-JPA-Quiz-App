package com.sopromadze.service;

import java.util.List;

import com.sopromadze.entities.Quiz;

public interface QuizService {

	void saveQuiz(Quiz quiz);

	List<Quiz> getAllQuizzes();

	Quiz getQuiz(int quizId);

	Quiz updateQuiz(Quiz quiz);

	void deleteQuiz(int quizId);

}