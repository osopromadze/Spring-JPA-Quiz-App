package com.sopromadze.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sopromadze.entities.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext(unitName = "quiz_PU")
	private EntityManager entityManager;
	
	@Override
	public void register(User user) {
		entityManager.persist(user);
	}
	
	@Override
	public User login(String username, String password) {
		String queryString = "select u from User u where u.username = ?1 and u.password = ?2";
		TypedQuery<User> typedQuery = entityManager.createQuery(queryString, User.class);
		
		typedQuery.setParameter(1, username);
		typedQuery.setParameter(2, password);
		
		List<User> users = typedQuery.getResultList();
		
		return users.isEmpty() ? null : users.get(0);
	}
	
	@Override
	public User getUserByUsername(String username) {
		String queryString = "select u from User u where u.username = ?1";
		TypedQuery<User> typedQuery = entityManager.createQuery(queryString, User.class);
		typedQuery.setParameter(1, username);
		
		List<User> users = typedQuery.getResultList();
		
		return users.isEmpty() ? null : users.get(0);
		
	}
	
	@Override
	public User getUserByEmail(String email) {
		String queryString = "select u from User u where u.email = ?1";
		TypedQuery<User> typedQuery = entityManager.createQuery(queryString, User.class);
		typedQuery.setParameter(1, email);
		
		List<User> users = typedQuery.getResultList();
		
		return users.isEmpty() ? null : users.get(0);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers(){
		Query query = entityManager.createQuery("select u from User u");
		
		return query.getResultList();
	}
	
	@Override
	public User updateUser(User user) {
		try {
			return entityManager.merge(user);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}