package com.kaua.hruser.form;

import javax.validation.constraints.NotNull;

import com.kaua.hruser.enums.RedeEnsinoEnum;

public class InstituicaoForm {

	private Long codigoMec;

	@NotNull
	private String nome;

	@NotNull
	private String municipio;

	@NotNull
	private RedeEnsinoEnum redeEnsino;

	@NotNull
	private ContatoForm contato;

	public InstituicaoForm() {
	}

	public InstituicaoForm(Long codigoMec, @NotNull String nome, @NotNull String municipio,
			@NotNull RedeEnsinoEnum redeEnsino, ContatoForm contato) {
		this.codigoMec = codigoMec;
		this.nome = nome;
		this.municipio = municipio;
		this.redeEnsino = redeEnsino;
		this.contato = contato;
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

	public ContatoForm getContato() {
		return contato;
	}

	public void setContato(ContatoForm contato) {
		this.contato = contato;
	}

}
