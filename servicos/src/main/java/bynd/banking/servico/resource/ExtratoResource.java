package bynd.banking.servico.resource;

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

import bynd.banking.servico.form.ExtratoForm;
import bynd.banking.servico.model.Extrato;
import bynd.banking.servico.service.ExtratoService;

@RestController
@RequestMapping("/extrato")
public class ExtratoResource {

	@Autowired
	ExtratoService service;

	@GetMapping()
	public ResponseEntity<List<Extrato>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<Extrato> findById(@PathVariable Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Extrato> saveExtrato(@RequestBody ExtratoForm form) {
		return new ResponseEntity<>(service.saveExtrato(form), HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Extrato> updateExtrato(@RequestBody Extrato extrato) {
		return new ResponseEntity<>(service.updateExtrato(extrato), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Extrato> delete(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(service.deleteExtrato(id), HttpStatus.OK);
	}
}
