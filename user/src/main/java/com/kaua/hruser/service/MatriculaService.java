package com.kaua.hruser.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaua.hruser.model.Matricula;
import com.kaua.hruser.repository.MatriculaRepository;
import com.kaua.hruser.stream.MatriculaPublisher;

@Service
public class MatriculaService {

	@Autowired
	MatriculaRepository repository;

	@Autowired
	MatriculaPublisher publisher;

	public List<Matricula> findAll() {
		return repository.findAll();
	}

	public Matricula findById(Long id) {
		Optional<Matricula> matricula = repository.findById(id);
		if (!matricula.isEmpty())
			return matricula.get();
		else
			throw new NoSuchElementException("Não encontramos a matricual com o id " + id);
	}

	public Matricula saveMatricula(Matricula matricula) throws Exception {

		publisher.saveMatricula(matricula);

		return matricula;
	}

	public Matricula updateMatricula(Matricula matricula) throws Exception {

		Matricula verifiedMatricula = this.findById(matricula.getIdMatricula());

		publisher.updateMatricula(matricula);

		return matricula;
	}

	public Matricula deleteMatricula(Long id) throws Exception {

		Matricula verifiedMatricula = this.findById(id);

		publisher.deleteMatricula(id);

		return verifiedMatricula;
	}

	public void save(Matricula matricula) {
		repository.save(matricula);
	}

	public void update(Matricula matricula) {
		repository.save(matricula);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
