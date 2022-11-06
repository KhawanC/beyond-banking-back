package com.kaua.hruser.form;

import javax.validation.constraints.NotNull;

public class ContatoForm {

	@NotNull
	private Integer cep;

	@NotNull
	private String bairro;

	@NotNull
	private String cidade;

	@NotNull
	private String estado;

	private String logradouro;

	@NotNull
	private Integer numero;

	private String complemento;

	private Long celular;

	private Long telefone;

	public ContatoForm() {
	}

	public ContatoForm(@NotNull Integer cep, @NotNull String bairro, @NotNull String cidade, @NotNull String estado,
			String logradouro, @NotNull Integer numero, String complemento, Long celular, Long telefone) {
		super();
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.celular = celular;
		this.telefone = telefone;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

}
