package com.kaua.hruser.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaua.hruser.model.Contato;
import com.kaua.hruser.repository.ContatoRepository;
import com.kaua.hruser.stream.ContatoPublisher;

@Service
public class ContatoService {

	@Autowired
	ContatoRepository repository;
	
	@Autowired
	ContatoPublisher publisher;
	
	public List<Contato> findAll() {
		return repository.findAll();
	}
	
	public Contato findById(Long id) {
		Optional<Contato> contato = repository.findById(id);
		if(!contato.isEmpty())
			return contato.get();
		else
			throw new NoSuchElementException("Nao encontramos o contato com o id " + id);
	}
	
	public List<Contato> findByCep(Integer cep) {
		Optional<Contato> contato = repository.findByCep(cep);
		if(!contato.isEmpty())
			return contato.stream().toList();
		else
			throw new NoSuchElementException("Nao encontramos nenhum contato com o cep " + cep);
	}
	
	public List<Contato> findByCidade(String cidade) {
		Optional<Contato> contato = repository.findByCidade(cidade);
		if(!contato.isEmpty())
			return contato.stream().toList();
		else
			throw new NoSuchElementException("Nao encontramos nenhum contato na cidade " + cidade);
	}
	
	public Contato saveContato(Contato contato) throws Exception {
		
		publisher.saveContato(contato);
		
		return contato;
	}
	
	public void save(Contato contato) {
		repository.save(contato);
	}
	
	public void update(Contato contato) {
		repository.save(contato);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
