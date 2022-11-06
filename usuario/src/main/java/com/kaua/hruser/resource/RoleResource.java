package com.kaua.hruser.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaua.hruser.enums.RoleEnum;
import com.kaua.hruser.model.Role;
import com.kaua.hruser.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleResource {
	
	@Autowired
	RoleService service;
	
	@GetMapping()
	public ResponseEntity<List<Role>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/byRoleName")
	public ResponseEntity<Role> findByRoleName(@RequestBody RoleEnum roleName) {
	    return new ResponseEntity<>(service.findByName(roleName).get(), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Role> save(@RequestBody RoleEnum form) {
		return new ResponseEntity<>(service.save(form), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.deleteById(id);
		return new ResponseEntity<>("User deleted successfuly!", HttpStatus.OK);
	}
}
