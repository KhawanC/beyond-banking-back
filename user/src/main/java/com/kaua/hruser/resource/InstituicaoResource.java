package com.kaua.hruser.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaua.hruser.form.InstituicaoForm;
import com.kaua.hruser.form.MatriculaForm;
import com.kaua.hruser.model.Instituicao;
import com.kaua.hruser.service.InstituicaoService;

@RestController
@RequestMapping("/instituicao")
public class InstituicaoResource {

	@Autowired
	InstituicaoService service;

	@GetMapping()
	public ResponseEntity<List<Instituicao>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<Instituicao> findById(@PathVariable Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Instituicao> saveInstituicao(@RequestBody InstituicaoForm form) throws Exception {
		return new ResponseEntity<>(service.saveInstituicao(form), HttpStatus.OK);
	}
	
	@PostMapping("/adicionarMatriculas")
	public ResponseEntity<Instituicao> adicionarMatriculas(@RequestBody MatriculaForm form) throws Exception {
		return new ResponseEntity<>(service.adicionarMatriculas(form), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Instituicao> delete(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(service.deleteInstituicao(id), HttpStatus.OK);
	}
}
