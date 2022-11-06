package com.kaua.hruser.converter;

import org.springframework.stereotype.Component;

import com.kaua.hruser.form.InstituicaoForm;
import com.kaua.hruser.model.Contato;
import com.kaua.hruser.model.Instituicao;

@Component
public class InstituicaoConverter {

	public Instituicao InstituicaoFormToInstituicao(InstituicaoForm form) {
		Instituicao model = new Instituicao();
		
		model.setCodigoMec(form.getCodigoMec());
		model.setMunicipio(form.getMunicipio());
		model.setNome(form.getNome());
		model.setRedeEnsino(form.getRedeEnsino());
		
		return model;
	}
	
	public Contato InstituicaoFormToContato(InstituicaoForm form) {
		Contato contato = new Contato();
		
		contato.setBairro(form.getContato().getBairro());
		contato.setCelular(form.getContato().getCelular());
		contato.setCep(form.getContato().getCep());
		contato.setCidade(form.getContato().getCidade());
		contato.setComplemento(form.getContato().getComplemento());
		contato.setEstado(form.getContato().getEstado());
		contato.setLogradouro(form.getContato().getLogradouro());
		contato.setNumero(form.getContato().getNumero());
		contato.setTelefone(form.getContato().getTelefone());
		
		return contato;
	}
}
