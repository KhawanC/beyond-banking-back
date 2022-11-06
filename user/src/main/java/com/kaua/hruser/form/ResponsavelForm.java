package com.kaua.hruser.form;

import java.time.LocalDate;

public class ResponsavelForm {

	private String nomeCompleto;

	private String email;

	private LocalDate dataNascimento;

	private String escolaParceira;

	private Long celular;

	private String senha;

	public ResponsavelForm() {
	}

	public ResponsavelForm(String nomeCompleto, String email, LocalDate dataNascimento, String escolaParceira,
			Long celular, String senha) {
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.escolaParceira = escolaParceira;
		this.celular = celular;
		this.senha = senha;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEscolaParceira() {
		return escolaParceira;
	}

	public void setEscolaParceira(String escolaParceira) {
		this.escolaParceira = escolaParceira;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
