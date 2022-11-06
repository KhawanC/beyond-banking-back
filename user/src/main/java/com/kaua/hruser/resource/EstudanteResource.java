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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/byCpf/{cpf}")
	public ResponseEntity<Estudante> findByCpf(@PathVariable Long cpf) {
		return new ResponseEntity<>(service.findByCpf(cpf), HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Estudante> updateEstudante(@RequestBody Estudante estudante) throws Exception {
		return new ResponseEntity<>(service.updateEstudante(estudante), HttpStatus.OK);
	}
	
	@PutMapping("/adicionarCreditos")
	public ResponseEntity<Estudante> updateCreditos(@RequestParam(name = "cpf") Long cpf, @RequestParam(name = "qtdCreditos") Integer qtdCreditos) throws Exception {
		return new ResponseEntity<>(service.updateCreditos(cpf, qtdCreditos), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Estudante> delete(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(service.deleteEstudante(id), HttpStatus.OK);
	}
}
