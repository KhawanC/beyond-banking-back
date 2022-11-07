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

import com.kaua.hruser.model.Matricula;
import com.kaua.hruser.service.MatriculaService;

@RestController
@RequestMapping("/matricula")
public class MatriculaResource {

	@Autowired
	MatriculaService service;

	@GetMapping()
	public ResponseEntity<List<Matricula>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<Matricula> findById(@PathVariable Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Matricula> saveInstituicao(@RequestBody Matricula matricula) throws Exception {
		return new ResponseEntity<>(service.saveMatricula(matricula), HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Matricula> updateInstituicao(@RequestBody Matricula matricula) throws Exception {
		return new ResponseEntity<>(service.updateMatricula(matricula), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Matricula> delete(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(service.deleteMatricula(id), HttpStatus.OK);
	}
}
