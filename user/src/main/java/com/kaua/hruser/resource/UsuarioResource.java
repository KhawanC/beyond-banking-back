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

import com.kaua.hruser.form.ResponsavelEstudanteForm;
import com.kaua.hruser.model.Usuario;
import com.kaua.hruser.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	UsuarioService service;
	
	@GetMapping()
	public ResponseEntity<List<Usuario>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/byId/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/byEmail/{email}")
	public ResponseEntity<Usuario> findByEmail(@PathVariable String email) {
		return new ResponseEntity<>(service.findByEmail(email), HttpStatus.OK);
	}
	
	@PostMapping("/responsavel")
	public ResponseEntity<Usuario> saveResponsavel(@RequestBody ResponsavelEstudanteForm form) throws Exception {
		return new ResponseEntity<>(service.saveResponsavel(form), HttpStatus.OK);
	}
	
	@PostMapping("/estudante")
	public ResponseEntity<Usuario> saveEstudante(@RequestBody ResponsavelEstudanteForm form) throws Exception {
		return new ResponseEntity<>(service.saveEstudante(form), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.deleteById(id);
		return new ResponseEntity<>("User deleted successfuly!", HttpStatus.OK);
	}
}
