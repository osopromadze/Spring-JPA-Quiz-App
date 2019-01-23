package com.sopromadze.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopromadze.entities.Question;

@Repository
@Transactional
public class QuestionDaoImpl implements QuestionDao {
	@PersistenceContext(unitName = "quiz_PU")
	private EntityManager entityManager;
	
	@Override
	public Question saveQuestion(Question question) {
		entityManager.persist(question);
		entityManager.flush();
		entityManager.detach(question);
		return question;
	}
	
	@Override
	public Question getQuestion(int id) {
		return entityManager.find(Question.class, id);
	}
	
	@Override
	public Question updateQuestion(Question question) {
		try {
			Question updatedQuestion = entityManager.merge(question);
			return updatedQuestion;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	
	@Override
	public void deleteQuestion(Question question) {
		try {
			entityManager.remove(question);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
