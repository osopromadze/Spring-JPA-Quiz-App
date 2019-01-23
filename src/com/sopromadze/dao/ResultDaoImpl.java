package com.sopromadze.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopromadze.entities.Result;

@Repository
@Transactional
public class ResultDaoImpl implements ResultDao {
	@PersistenceContext(unitName = "quiz_PU")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.sopromadze.dao.ResultDao#saveResult(com.sopromadze.entities.Result)
	 */
	@Override
	public void saveResult(Result result) {
		entityManager.persist(result);
	}
}
