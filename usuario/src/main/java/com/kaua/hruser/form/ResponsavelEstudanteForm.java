package com.kaua.hruser.form;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.kaua.hruser.enums.RoleEnum;

public class ResponsavelEstudanteForm {

	@NotNull
	private RoleEnum funcaoUsuario;

	@NotNull
	private String nomeCompleto;

	@NotNull
	private String email;

	@NotNull
	private Long cpf;

	@NotNull
	private LocalDate dataNascimento;

	@NotNull
	private String senha;

	private ContatoForm contato;

	public ResponsavelEstudanteForm() {
	}

	public ResponsavelEstudanteForm(@NotNull RoleEnum funcaoUsuario, @NotNull String nomeCompleto,
			@NotNull String email, @NotNull Long cpf, @NotNull LocalDate dataNascimento, @NotNull String senha,
			ContatoForm contato) {
		this.funcaoUsuario = funcaoUsuario;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.contato = contato;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ContatoForm getContato() {
		return contato;
	}

	public void setContato(ContatoForm contato) {
		this.contato = contato;
	}

	public RoleEnum getFuncaoUsuario() {
		return funcaoUsuario;
	}

	public void setFuncaoUsuario(RoleEnum funcaoUsuario) {
		this.funcaoUsuario = funcaoUsuario;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

}
