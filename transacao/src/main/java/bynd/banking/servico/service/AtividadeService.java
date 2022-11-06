package bynd.banking.servico.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bynd.banking.servico.dto.EstudanteDTO;
import bynd.banking.servico.dto.UsuarioDTO;
import bynd.banking.servico.feignClient.UsuarioFeign;
import bynd.banking.servico.form.GanhadorAtividadeForm;
import bynd.banking.servico.model.Atividade;
import bynd.banking.servico.repository.AtividadeRepository;

@Service
public class AtividadeService {

	@Autowired
	AtividadeRepository repositorty;

	@Autowired
	UsuarioFeign usuarioFeign;

	public List<Atividade> findAll() {
		return repositorty.findAll();
	}

	public Atividade findById(Long id) {
		Optional<Atividade> atividade = repositorty.findById(id);
		if (!atividade.isEmpty())
			return atividade.get();
		else
			throw new NoSuchElementException("Não encontramos a atividade com o id " + id);
	}

	public Atividade findByNome(String nome) {
		Optional<Atividade> atividade = repositorty.findByNome(nome);
		if (!atividade.isEmpty())
			return atividade.get();
		else
			throw new NoSuchElementException("Não encontramos a atividade com o nome " + nome);
	}

	public Atividade saveAtividade(Atividade atividade) {

		return this.save(atividade);
	}

	public EstudanteDTO completarAtividade(GanhadorAtividadeForm form) {
		Atividade atividade = this.findByNome(form.getNomeAtividade());
		EstudanteDTO estudante = usuarioFeign.updateCreditos(form.getCpfGanhador(), atividade.getPremio()).getBody();

		return estudante;
	}

	public Atividade updateAtividade(Atividade atividade) {
		Atividade virifiedAtividade = this.findById(atividade.getId());

		return this.update(atividade);
	}

	public Atividade deleteAtividade(Long id) {
		Atividade virifiedAtividade = this.findById(id);

		this.delete(id);

		return virifiedAtividade;
	}

	public Atividade save(Atividade atividade) {
		return repositorty.save(atividade);
	}

	public Atividade update(Atividade atividade) {
		return repositorty.save(atividade);
	}

	public void delete(Long id) {
		repositorty.deleteById(id);
	}

}
