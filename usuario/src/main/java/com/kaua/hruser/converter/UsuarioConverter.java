package com.kaua.hruser.converter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.kaua.hruser.form.ResponsavelEstudanteForm;
import com.kaua.hruser.model.Estudante;
import com.kaua.hruser.model.Responsavel;
import com.kaua.hruser.model.Role;
import com.kaua.hruser.model.Usuario;
import com.kaua.hruser.service.RoleService;

@Component
public class UsuarioConverter {

	@Autowired
	RoleService roleService;

	@Autowired
	ContatoConverter contatoConverter;

	@Autowired
	BCryptPasswordEncoder encoder;

	public Usuario responsavelEstudanteFormToUsuario(ResponsavelEstudanteForm form) {
		Usuario usuario = new Usuario();

		Set<Role> roles = new HashSet<>();
		roles.add(roleService.findByName(form.getFuncaoUsuario()).get());

		usuario.setDataNascimento(form.getDataNascimento());
		usuario.setEmail(form.getEmail());
		usuario.setNomeCompleto(form.getNomeCompleto());
		usuario.setRoles(roles);
		usuario.setSenha(encoder.encode(form.getSenha()));
		usuario.setSaldo(new BigDecimal("0.0"));
		usuario.setCpf(form.getCpf());
		usuario.setContato(contatoConverter.FormToModel(form.getContato()));

		return usuario;
	}

	public Responsavel responsavelEstudanteFormToResponsavel(ResponsavelEstudanteForm form) {
		Responsavel responsavel = new Responsavel();

		Set<Estudante> listaEstudantes = new HashSet<>();

		responsavel.setListaDependentes(listaEstudantes);
		responsavel.setUsuario(null);

		return responsavel;
	}

	public Estudante responsavelEstudanteFormToEstudante(ResponsavelEstudanteForm form) {
		Estudante estudante = new Estudante();

		estudante.setIsTranferenciaAutorizada(false);
		estudante.setPontosAtividades(0);

		return estudante;
	}
}
