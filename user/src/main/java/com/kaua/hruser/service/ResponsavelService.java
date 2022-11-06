package com.kaua.hruser.service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import javax.management.InstanceAlreadyExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaua.hruser.form.DependenteForm;
import com.kaua.hruser.model.Estudante;
import com.kaua.hruser.model.Responsavel;
import com.kaua.hruser.model.Usuario;
import com.kaua.hruser.repository.ResponsavelRepository;
import com.kaua.hruser.stream.ResponsavelPublisher;

@Service
public class ResponsavelService {

	@Autowired
	ResponsavelRepository repository;

	@Autowired
	ResponsavelPublisher publisher;

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	EstudanteService estudanteService;

	public List<Responsavel> findAll() {
		return repository.findAll();
	}

	public Responsavel findById(Long id) {
		Optional<Responsavel> responsavel = repository.findById(id);
		if (!responsavel.isEmpty())
			return responsavel.get();
		else
			throw new NoSuchElementException("Não encontramos o responsavel com o id " + id);
	}
	
	public Responsavel findByCpf(Long cpf) {
		Usuario usuario = usuarioService.findByCpf(cpf);
		Optional<Responsavel> responsavel = repository.findByUsuario(usuario);
		if(!responsavel.isEmpty())
			return responsavel.get();
		else 
			throw new NoSuchElementException("Não encontramos o responsavel com o cpf " + cpf);
	}

	public Responsavel saveResponsavel(Responsavel responsavel) throws Exception {

		publisher.saveResponsavel(responsavel);

		return responsavel;
	}
	
	public Set<Estudante> adicionarDependente(DependenteForm form) throws Exception {
		Responsavel responsavel = this.findByCpf(form.getCpfResponsavel());
		Set<Estudante> listaEstudante = new HashSet<>();
		
		for(Long cpf : form.getListaCpf()) {
			Estudante dependente = estudanteService.findByCpf(cpf);
			if(listaEstudante.contains(dependente)) {
				throw new InstanceAlreadyExistsException("O dependente com o cpf " + cpf + " já existe!");
			} else {
				listaEstudante.add(dependente);
			}
		}
		
		responsavel.setListaDependentes(listaEstudante);
		this.update(responsavel);
		
		return listaEstudante;
	}

	public Responsavel updateResponsavel(Responsavel responsavel) throws Exception {
		Responsavel verifiedResponsavel = this.findById(responsavel.getId());

		publisher.saveResponsavel(responsavel);

		return responsavel;
	}

	public Responsavel deleteResponsavel(Long id) throws Exception {
		Responsavel verifiedResponsavel = this.findById(id);

		publisher.deleteResponsavel(id);

		return verifiedResponsavel;
	}

	public void save(Responsavel responsavel) {
		repository.save(responsavel);
	}

	public void update(Responsavel responsavel) {
		repository.save(responsavel);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
