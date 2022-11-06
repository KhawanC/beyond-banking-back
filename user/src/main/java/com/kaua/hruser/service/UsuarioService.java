package com.kaua.hruser.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kaua.hruser.converter.UsuarioConverter;
import com.kaua.hruser.form.ResponsavelEstudanteForm;
import com.kaua.hruser.model.Contato;
import com.kaua.hruser.model.Estudante;
import com.kaua.hruser.model.Responsavel;
import com.kaua.hruser.model.Usuario;
import com.kaua.hruser.repository.UsuarioRepository;
import com.kaua.hruser.stream.UsuarioPublisher;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;

	@Autowired
	UsuarioConverter usuarioConverter;

	@Autowired
	ResponsavelService responsavelService;

	@Autowired
	EstudanteService estudanteService;

	@Autowired
	UsuarioPublisher publisher;

	@Autowired
	ContatoService contatoService;

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
	
	public Usuario findByCpf(Long cpf) {
		Optional<Usuario> usuario = repository.findByCpf(cpf);
		if(!usuario.isEmpty())
			return usuario.get();
		else
			throw new NoSuchElementException("Não encontramos o usuário com o cpf " + cpf);
	}

	public Usuario saveResponsavel(ResponsavelEstudanteForm form) throws Exception {

		Usuario usuario = usuarioConverter.responsavelEstudanteFormToUsuario(form);
		Responsavel responsavel = usuarioConverter.responsavelEstudanteFormToResponsavel(form);
		Contato contato = contatoService.save(usuario.getContato());

		usuario.setSenha(encoder.encode(usuario.getSenha()));
		usuario.setContato(contato);

		usuario = this.save(usuario);
		responsavel.setUsuario(this.findByEmail(usuario.getEmail()));
		responsavelService.save(responsavel);

		return usuario;
	}

	public Usuario saveEstudante(ResponsavelEstudanteForm form) throws Exception {

		Usuario usuario = usuarioConverter.responsavelEstudanteFormToUsuario(form);
		Estudante estudante = usuarioConverter.responsavelEstudanteFormToEstudante(form);
		Contato contato = contatoService.save(usuario.getContato());

		usuario.setSenha(encoder.encode(usuario.getSenha()));
		usuario.setContato(contato);

		usuario = this.save(usuario);
		estudante.setUsuario(this.findByEmail(usuario.getEmail()));
		estudanteService.save(estudante);

		return usuario;
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	public void update(Usuario usuario) {
		repository.save(usuario);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
