package com.sopromadze.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sopromadze.entities.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	@PersistenceContext(unitName = "quiz_PU")
	private EntityManager entityManager;
	
	@Override
	public Role getRole(int id) {
		return entityManager.find(Role.class, id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Role> getAllRoles(){
		Query query = entityManager.createQuery("select r from Role r");
		
		return query.getResultList();
	}
}
