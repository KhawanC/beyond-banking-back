package com.kaua.hruser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@Column(name = "id")
	private Long idMatricula;

	@Column(name = "nome_aluno")
	private String nomeAluno;

	@Column(name = "cpf")
	private Long cpf;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_instituicao_ensino")
	private InstituicaoEnsino instituicaoEnsino;

	public Matricula() {
	}

	public Matricula(Long idMatricula, String nomeAluno, Long cpf, InstituicaoEnsino instituicaoEnsino) {
		this.idMatricula = idMatricula;
		this.nomeAluno = nomeAluno;
		this.cpf = cpf;
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public Long getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Long idMatricula) {
		this.idMatricula = idMatricula;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public InstituicaoEnsino getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(InstituicaoEnsino instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

}
