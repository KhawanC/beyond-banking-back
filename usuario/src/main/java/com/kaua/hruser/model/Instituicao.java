package com.kaua.hruser.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.kaua.hruser.enums.RedeEnsinoEnum;

@Entity
@Table(name = "instituicao")
public class Instituicao {

	@Id
	@Column(name = "codigo_mec", unique = true)
	private Long codigoMec;

	@Column(name = "nome", unique = true)
	private String nome;

	@Column(name = "municipio")
	private String municipio;

	@Column(name = "rede_ensino")
	private RedeEnsinoEnum redeEnsino;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_contato")
	private Contato contato;

	@OneToMany(mappedBy = "instituicaoEnsino", cascade = CascadeType.ALL)
	private Set<Matricula> listaMatriculas;

	public Instituicao() {
	}

	public Instituicao(Long codigoMec, String nome, String municipio, RedeEnsinoEnum redeEnsino, Contato contato,
			Set<Matricula> listaMatriculas) {
		this.codigoMec = codigoMec;
		this.nome = nome;
		this.municipio = municipio;
		this.redeEnsino = redeEnsino;
		this.contato = contato;
		this.listaMatriculas = listaMatriculas;
	}

	public Long getCodigoMec() {
		return codigoMec;
	}

	public void setCodigoMec(Long codigoMec) {
		this.codigoMec = codigoMec;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public RedeEnsinoEnum getRedeEnsino() {
		return redeEnsino;
	}

	public void setRedeEnsino(RedeEnsinoEnum redeEnsino) {
		this.redeEnsino = redeEnsino;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Set<Matricula> getListaMatriculas() {
		return listaMatriculas;
	}

	public void setListaMatriculas(Set<Matricula> listaMatriculas) {
		this.listaMatriculas = listaMatriculas;
	}

}
