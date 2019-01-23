package com.sopromadze.dao;

import java.util.List;

import com.sopromadze.entities.Role;

public interface RoleDao {

	Role getRole(int id);

	List<Role> getAllRoles();

}