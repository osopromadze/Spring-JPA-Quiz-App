package com.sopromadze.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopromadze.dao.RoleDao;
import com.sopromadze.entities.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role getRole(int id) {
		return roleDao.getRole(id);
	}
	
	@Override
	public List<Role> getAllRoles(){
		return roleDao.getAllRoles();
	}
}
