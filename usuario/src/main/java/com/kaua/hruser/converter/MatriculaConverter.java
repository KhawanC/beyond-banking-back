package com.kaua.hruser.converter;

import org.springframework.stereotype.Component;

import com.kaua.hruser.form.AlunoMatriculaForm;
import com.kaua.hruser.model.Matricula;

@Component
public class MatriculaConverter {

	public Matricula alunoMatriculaFormToMatricula(AlunoMatriculaForm form) {
		Matricula matricula = new Matricula();
		
		matricula.setCpf(form.getCpf());
		matricula.setIdMatricula(form.getIdMatricula());
		matricula.setNomeAluno(form.getNomeAluno());
		
		return matricula;
	}
}
