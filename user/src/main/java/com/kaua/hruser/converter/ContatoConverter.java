package com.kaua.hruser.converter;

import org.springframework.stereotype.Component;

import com.kaua.hruser.form.ContatoForm;
import com.kaua.hruser.model.Contato;

@Component
public class ContatoConverter {

	public Contato FormToModel(ContatoForm form) {
		Contato model = new Contato();
		
		model.setBairro(form.getBairro());
		model.setCelular(form.getCelular());
		model.setCep(form.getCep());
		model.setCidade(form.getBairro());
		model.setComplemento(form.getComplemento());
		model.setEstado(form.getEstado());
		model.setLogradouro(form.getLogradouro());
		model.setNumero(form.getNumero());
		model.setTelefone(form.getTelefone());
		
		return model;
	}
}
