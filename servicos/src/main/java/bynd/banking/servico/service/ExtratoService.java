package bynd.banking.servico.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bynd.banking.servico.converter.ExtratoConverter;
import bynd.banking.servico.dto.UsuarioDTO;
import bynd.banking.servico.feignClient.UsuarioFeign;
import bynd.banking.servico.form.ExtratoForm;
import bynd.banking.servico.model.Extrato;
import bynd.banking.servico.repository.ExtratoRepository;

@Service
public class ExtratoService {
	
	//TODO Implementar o Kafka

	@Autowired
	ExtratoRepository repository;

	@Autowired
	UsuarioFeign usuarioFeign;
	
	@Autowired
	ExtratoConverter converter;

	public List<Extrato> findAll() {
		return repository.findAll();
	}

	public Extrato findById(Long id) {
		Optional<Extrato> extrato = repository.findById(id);
		if (!extrato.isEmpty())
			return extrato.get();
		else
			throw new NoSuchElementException("Não encontramos o extrato com o id " + id);
	}

	//TODO Verificar se o usuairo é um responsavel ou um estudante, e verificação caso o estudante não possa realizar transações
	public Extrato saveExtrato(ExtratoForm form) {
		Extrato extrato = converter.ExtratoFormToExtrato(form);
		UsuarioDTO usuario = usuarioFeign.findUsuarioByCpf(extrato.getCpfRemetente()).getBody();
		if (extrato.getSaldo().compareTo(usuario.getSaldo()) > 1) {
			throw new IllegalArgumentException("Você não tem saldo suficiente para realizar a operação");
		} else {
			usuario.setSaldo(usuario.getSaldo().subtract(extrato.getSaldo()));
			usuarioFeign.updateUsuario(usuario);
		}
		
		Extrato newExtrato = this.save(extrato);

		return extrato;
	}
	
	public Extrato updateExtrato(Extrato extrato) {
		
		//TODO Ao atualizar extrato a diferença do valor deve ser atualizado no saldo do usuário
		
		Extrato verifiedExtrato = this.findById(extrato.getId());
		
		this.update(extrato);
		
		return extrato;
	}
	
	public Extrato deleteExtrato(Long id) {
		Extrato verifiedExtrato = this.findById(id);
		
		this.delete(id);
		
		return verifiedExtrato;
	}

	public Extrato save(Extrato extrato) {
		return repository.save(extrato);
	}

	public Extrato update(Extrato extrato) {
		return repository.save(extrato);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
