package com.kaua.hruser.converter;

import org.springframework.stereotype.Component;

import com.kaua.hruser.enums.RoleEnum;
import com.kaua.hruser.model.Role;

@Component
public class RoleConverter {

	public Role EnumToModel(RoleEnum roleName) {
		Role role = new Role();

		role.setRoleName(roleName);

		return role;
	}
}
