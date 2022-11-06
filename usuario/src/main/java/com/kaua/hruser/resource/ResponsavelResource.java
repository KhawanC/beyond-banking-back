package com.kaua.hruser.resource;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaua.hruser.form.DependenteForm;
import com.kaua.hruser.model.Estudante;
import com.kaua.hruser.model.Responsavel;
import com.kaua.hruser.service.ResponsavelService;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelResource {

	@Autowired
	ResponsavelService service;

	@GetMapping()
	public ResponseEntity<List<Responsavel>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<Responsavel> findById(@PathVariable Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/adicionarDependente")
	public ResponseEntity<Set<Estudante>> adicionarDependente(@RequestBody DependenteForm form) throws Exception {
		return new ResponseEntity<>(service.adicionarDependente(form), HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<Responsavel> updateInstituicao(@RequestBody Responsavel responsavel) throws Exception {
		return new ResponseEntity<>(service.updateResponsavel(responsavel), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Responsavel> delete(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(service.deleteResponsavel(id), HttpStatus.OK);
	}
}
