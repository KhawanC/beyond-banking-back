package com.kaua.hruser.form;

public class AlunoMatriculaForm {

	private Long idMatricula;

	private String nomeAluno;

	private Long cpf;

	public AlunoMatriculaForm() {
	}

	public AlunoMatriculaForm(Long idMatricula, String nomeAluno, Long cpf) {
		super();
		this.idMatricula = idMatricula;
		this.nomeAluno = nomeAluno;
		this.cpf = cpf;
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

}
