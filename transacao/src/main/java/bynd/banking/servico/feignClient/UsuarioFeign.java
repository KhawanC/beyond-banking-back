package bynd.banking.servico.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import bynd.banking.servico.dto.EstudanteDTO;
import bynd.banking.servico.dto.UsuarioDTO;

@Component
@FeignClient(name = "bynd-usuario")
public interface UsuarioFeign {

	@GetMapping(value = "/usuario/byCpf/{cpf}")
	ResponseEntity<UsuarioDTO> findUsuarioByCpf(@PathVariable Long cpf);

	@PutMapping("/usuario/")
	ResponseEntity<UsuarioDTO> updateUsuario(@RequestBody UsuarioDTO usuario);
	
	@PutMapping("/estudante/adicionarCreditos")
	ResponseEntity<EstudanteDTO> updateCreditos(@RequestParam(name = "cpf") Long cpf,@RequestParam(name = "qtdCreditos") Integer qtdCreditos);
}
