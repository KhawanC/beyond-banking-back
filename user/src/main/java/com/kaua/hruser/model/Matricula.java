package com.kaua.hruser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@Column(name = "idMatricula")
	private Long idMatricula;

	@Column(name = "nome_aluno", unique = true)
	private String nomeAluno;

	@Column(name = "cpf", unique = true)
	private Long cpf;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_instituicao_ensino")
	private Instituicao instituicaoEnsino;

	public Matricula() {
	}

	public Matricula(Long idMatricula, String nomeAluno, Long cpf, Instituicao instituicaoEnsino) {
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

	public Instituicao getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(Instituicao instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

}
