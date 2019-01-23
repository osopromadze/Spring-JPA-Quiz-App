package com.sopromadze.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopromadze.entities.Answer;

@Repository
@Transactional
public class AnswerDaoImpl implements AnswerDao {
	
	@PersistenceContext(unitName = "quiz_PU")
	private EntityManager entityManager;
	
	@Override
	public void saveAnswer(Answer answer) {
		entityManager.persist(answer);
	}
	
	@Override
	public Answer updateAnswer(Answer answer) {
		try {
			return entityManager.merge(answer);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}
