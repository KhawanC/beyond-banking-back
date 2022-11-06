package com.kaua.hruser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kaua.hruser.converter.ResponsavelConverter;
import com.kaua.hruser.form.ResponsavelForm;
import com.kaua.hruser.model.Usuario;
import com.kaua.hruser.repository.UsuarioRepository;
import com.kaua.hruser.stream.UsuarioPublisher;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;

	@Autowired
	ResponsavelConverter responsavelConverter;

	@Autowired
	UsuarioPublisher publisher;

	@Autowired
	BCryptPasswordEncoder encoder;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario findById(Long id) {
		return repository.findById(id).get();
	}

	public Usuario findByEmail(String email) {
		return repository.findByEmail(email).get();
	}

	public Usuario saveResponsavel(ResponsavelForm form) throws Exception {

		Usuario usuario = responsavelConverter.FormToUsuario(form);
		usuario.setSenha(encoder.encode(usuario.getSenha()));

		publisher.saveUsuario(usuario);

		return usuario;
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void save(Usuario usuario) {
		repository.save(usuario);
	}
	
	public void update(Usuario usuario) {
		repository.save(usuario);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
