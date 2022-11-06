package com.kaua.hroauth.userDTO;

import com.kaua.hroauth.enums.RoleEnum;

public class RoleDTO {

	private Long id;

	private RoleEnum roleName;

	public RoleDTO() {
	}

	public RoleDTO(Long id, RoleEnum roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleEnum getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleEnum roleName) {
		this.roleName = roleName;
	}

}
