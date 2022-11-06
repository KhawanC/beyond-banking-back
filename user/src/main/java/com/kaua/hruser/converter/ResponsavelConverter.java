package com.kaua.hruser.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaua.hruser.enums.RoleEnum;
import com.kaua.hruser.form.ResponsavelForm;
import com.kaua.hruser.model.Role;
import com.kaua.hruser.model.Usuario;
import com.kaua.hruser.service.RoleService;

@Component
public class ResponsavelConverter {
	
	@Autowired
	RoleService roleService;

	public Usuario FormToUsuario(ResponsavelForm form) {
		Usuario usuario = new Usuario();
		
		Set<Role> roles = new HashSet<>();
		roles.add(roleService.findByName(RoleEnum.ROLE_RESPONSAVEL).get());
		
		usuario.setDataNascimento(form.getDataNascimento());
		usuario.setEmail(form.getEmail());
		usuario.setNomeCompleto(form.getNomeCompleto());
		usuario.setRoles(roles);
		usuario.setSenha(form.getSenha());
		
		return usuario;
	}
}
