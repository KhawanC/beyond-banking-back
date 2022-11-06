package com.kaua.hruser.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaua.hruser.model.Estudante;
import com.kaua.hruser.service.EstudanteService;

@RestController
@RequestMapping("/estudante")
public class EstudanteResource {

	@Autowired
	EstudanteService service;

	@GetMapping()
	public ResponseEntity<List<Estudante>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<Estudante> findById(@PathVariable Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Estudante> updateInstituicao(@RequestBody Estudante estudante) throws Exception {
		return new ResponseEntity<>(service.updateEstudante(estudante), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Estudante> delete(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(service.deleteEstudante(id), HttpStatus.OK);
	}
}
