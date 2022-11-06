package com.kaua.hruser.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.management.InstanceAlreadyExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaua.hruser.converter.InstituicaoConverter;
import com.kaua.hruser.converter.MatriculaConverter;
import com.kaua.hruser.form.AlunoMatriculaForm;
import com.kaua.hruser.form.InstituicaoForm;
import com.kaua.hruser.form.MatriculaForm;
import com.kaua.hruser.model.Contato;
import com.kaua.hruser.model.Instituicao;
import com.kaua.hruser.model.Matricula;
import com.kaua.hruser.repository.InstituicaoRepository;
import com.kaua.hruser.stream.InstituicaoPublisher;

@Service
public class InstituicaoService {

	@Autowired
	InstituicaoRepository repository;

	@Autowired
	MatriculaService matriculaService;

	@Autowired
	InstituicaoConverter converter;

	@Autowired
	MatriculaConverter matriculaConverter;

	@Autowired
	ContatoService contatoService;

	@Autowired
	InstituicaoPublisher publisher;

	public List<Instituicao> findAll() {
		return repository.findAll();
	}

	public Instituicao findById(Long id) {
		Optional<Instituicao> instituicao = repository.findById(id);
		if (!instituicao.isEmpty())
			return instituicao.get();
		else
			throw new NoSuchElementException("Não encontramos a instituição com o id " + id);
	}

	public Instituicao saveInstituicao(InstituicaoForm form) throws Exception {

		Instituicao instituicao = converter.InstituicaoFormToInstituicao(form);
		Contato contato = contatoService.save(converter.InstituicaoFormToContato(form));

		instituicao.setContato(contato);
		publisher.saveInstituicao(instituicao);

		return instituicao;
	}

	public Instituicao adicionarMatriculas(MatriculaForm form) throws Exception {
		Instituicao instituicao = this.findById(form.getIdInstituicao());

		for (Matricula matriculas : instituicao.getListaMatriculas()) {
			for (AlunoMatriculaForm matriculasForm : form.getMatriculas()) {
				if (matriculas.getIdMatricula() == matriculasForm.getIdMatricula()) {
					throw new InstanceAlreadyExistsException(
							"Uma matricula com o id " + matriculasForm.getIdMatricula() + " já existe!");
				}
			}
		}

		for (AlunoMatriculaForm matriculasForm : form.getMatriculas()) {
			Instituicao newInstituicao = this.findById(form.getIdInstituicao());
			Matricula matricula = (matriculaConverter.alunoMatriculaFormToMatricula(matriculasForm));
			matricula.setInstituicaoEnsino(newInstituicao);

			matriculaService.saveMatricula(matricula);
		}

		return instituicao;
	}

	public Instituicao updateInstituicao(Instituicao instituicao) throws Exception {
		Instituicao verifiedInstituicao = this.findById(instituicao.getCodigoMec());

		publisher.updateInstituicao(instituicao);

		return instituicao;
	}

	public Instituicao deleteInstituicao(Long id) throws Exception {
		Instituicao verifiedInstituicao = this.findById(id);

		publisher.deleteInstituicao(id);

		return verifiedInstituicao;
	}

	public void save(Instituicao instituicao) {
		repository.save(instituicao);
	}

	public void update(Instituicao instituicao) {
		repository.save(instituicao);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
