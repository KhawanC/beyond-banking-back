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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaua.hruser.form.ResponsavelForm;
import com.kaua.hruser.model.Usuario;
import com.kaua.hruser.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioResource {

	@Autowired
	UsuarioService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/byId/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/byEmail")
	public ResponseEntity<Usuario> findByEmail(@RequestParam String email) {
		return new ResponseEntity<>(service.findByEmail(email), HttpStatus.OK);
	}
	
	@PostMapping("/responsavel")
	public ResponseEntity<Usuario> saveUsuario(@RequestBody ResponsavelForm form) throws Exception {
		return new ResponseEntity<>(service.saveResponsavel(form), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.deleteById(id);
		return new ResponseEntity<>("User deleted successfuly!", HttpStatus.OK);
	}
}
