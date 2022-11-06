package com.kaua.hruser.form;

import java.util.Set;

public class MatriculaForm {

	private Long idInstituicao;

	private Set<AlunoMatriculaForm> matriculas;

	public MatriculaForm() {
	}

	public MatriculaForm(Long idInstituicao, Set<AlunoMatriculaForm> matriculas) {
		this.idInstituicao = idInstituicao;
		this.matriculas = matriculas;
	}

	public Long getIdInstituicao() {
		return idInstituicao;
	}

	public void setIdInstituicao(Long idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public Set<AlunoMatriculaForm> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<AlunoMatriculaForm> matriculas) {
		this.matriculas = matriculas;
	}

}
