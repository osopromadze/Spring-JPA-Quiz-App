package com.sopromadze.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sopromadze.entities.Quiz;

@Repository
@Transactional
public class QuizDaoImpl implements QuizDao {

	@PersistenceContext(unitName = "quiz_PU")
	private EntityManager entityManager;
	
	@Override
	public void saveQuiz(Quiz quiz) {
		entityManager.persist(quiz);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Quiz> getAllQuizzes(){
		Query query = entityManager.createQuery("select q from Quiz q");
		
		return query.getResultList();
	}
	
	@Override
	public Quiz getQuiz(int id) {
		return entityManager.find(Quiz.class, id);
	}
	
	@Override
	public Quiz updateQuiz(Quiz quiz) {
		try {
			return entityManager.merge(quiz);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	
	@Override
	public void deleteQuiz(Quiz quiz) {
		try {
			entityManager.remove(quiz);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
