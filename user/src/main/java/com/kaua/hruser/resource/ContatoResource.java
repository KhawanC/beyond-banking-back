package com.kaua.hruser.resource;

import java.util.List;

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

import com.kaua.hruser.model.Contato;
import com.kaua.hruser.service.ContatoService;

@RestController
@RequestMapping("/contato")
public class ContatoResource {

	@Autowired
	ContatoService service;

	@GetMapping()
	public ResponseEntity<List<Contato>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<Contato> findById(@PathVariable Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Contato> saveInstituicao(@RequestBody Contato contato) throws Exception {
		return new ResponseEntity<>(service.saveContato(contato), HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Contato> updateInstituicao(@RequestBody Contato contato) throws Exception {
		return new ResponseEntity<>(service.updateContato(contato), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Contato> delete(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(service.deleteContato(id), HttpStatus.OK);
	}
}
