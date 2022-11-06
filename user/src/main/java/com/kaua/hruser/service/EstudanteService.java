package com.kaua.hruser.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaua.hruser.model.Estudante;
import com.kaua.hruser.model.Usuario;
import com.kaua.hruser.repository.EstudanteRepository;
import com.kaua.hruser.stream.EstudantePublisher;

@Service
public class EstudanteService {

	@Autowired
	EstudanteRepository repository;
	
	@Autowired
	EstudantePublisher publisher;
	
	@Autowired
	UsuarioService usuarioService;
	
	public List<Estudante> findAll() {
		return repository.findAll();
	}
	
	public Estudante findById(Long id) {
		Optional<Estudante> estudante = repository.findById(id);
		
		if(!estudante.isEmpty())
			return estudante.get();
		else throw new NoSuchElementException("Nenhum encontramos o estudante com o id " + id);
	}
	
	public Estudante findByCpf(Long cpf) {
		Usuario usuario = usuarioService.findByCpf(cpf);
		Optional<Estudante> estudante = repository.findByUsuario(usuario);
		if(!estudante.isEmpty())
			return estudante.get();
		else 
			throw new NoSuchElementException("Não encontramos o estudante com o cpf " + cpf);
	}
	
	public Estudante saveEstudante(Estudante estudante) throws Exception {
		
		publisher.saveEstudante(estudante);
		
		return estudante;
	}
	
	public Estudante updateEstudante(Estudante estudante) throws Exception {
		Estudante verifiedEstudante = this.findById(estudante.getId());
		
		publisher.updateEstudante(estudante);
		
		return estudante;
	}

	public Estudante updateCreditos(Long cpf, Integer qtdCreditos) throws Exception {
		Estudante estudante = this.findByCpf(cpf);
		
		estudante.setPontosAtividades(estudante.getPontosAtividades() + qtdCreditos);

		
		return this.update(estudante);
	}
	
	public Estudante deleteEstudante(Long id) throws Exception {
		Estudante estudante = this.findById(id);
		
		publisher.deleteEstudante(id);
		
		return estudante;
	}
	
	public Estudante save(Estudante estudante) {
		return repository.save(estudante);
	}
	
	public Estudante update(Estudante estudante) {
		return repository.save(estudante);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
