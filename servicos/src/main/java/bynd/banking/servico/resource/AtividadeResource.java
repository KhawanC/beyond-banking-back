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

import bynd.banking.servico.dto.EstudanteDTO;
import bynd.banking.servico.form.GanhadorAtividadeForm;
import bynd.banking.servico.model.Atividade;
import bynd.banking.servico.service.AtividadeService;

@RestController
@RequestMapping("/atividade")
public class AtividadeResource {

	@Autowired
	AtividadeService service;

	@GetMapping()
	public ResponseEntity<List<Atividade>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<Atividade> findById(@PathVariable Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Atividade> saveExtrato(@RequestBody Atividade atividade) {
		return new ResponseEntity<>(service.saveAtividade(atividade), HttpStatus.OK);
	}

	@PostMapping("/concluirAtividade")
	public ResponseEntity<EstudanteDTO> concluirAtividade(@RequestBody GanhadorAtividadeForm form) {
		return new ResponseEntity<>(service.completarAtividade(form), HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Atividade> updateExtrato(@RequestBody Atividade atividade) {
		return new ResponseEntity<>(service.updateAtividade(atividade), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Atividade> delete(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(service.deleteAtividade(id), HttpStatus.OK);
	}
}
