package com.kaua.hruser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaua.hruser.converter.RoleConverter;
import com.kaua.hruser.enums.RoleEnum;
import com.kaua.hruser.model.Role;
import com.kaua.hruser.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository repository;

	@Autowired
	RoleConverter converter;

	public List<Role> findAll() {
		return repository.findAll();
	}
	
	public Optional<Role> findByName(RoleEnum roleName) {
	    return repository.findByRoleName(roleName);
	}

	public Role save(RoleEnum roleName) {
		Role role = converter.EnumToModel(roleName);
		return repository.save(role);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
