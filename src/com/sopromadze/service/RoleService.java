package com.sopromadze.service;

import java.util.List;

import com.sopromadze.entities.Role;

public interface RoleService {

	Role getRole(int id);

	List<Role> getAllRoles();

}