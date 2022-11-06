package com.kaua.hruser.form;

import java.util.Set;

public class DependenteForm {

	private Long cpfResponsavel;

	private Set<Long> listaCpf;

	public DependenteForm() {
	}

	public DependenteForm(Long cpfResponsavel, Set<Long> listaCpf) {
		super();
		this.cpfResponsavel = cpfResponsavel;
		this.listaCpf = listaCpf;
	}

	public Long getCpfResponsavel() {
		return cpfResponsavel;
	}

	public void setCpfResponsavel(Long cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}

	public Set<Long> getListaCpf() {
		return listaCpf;
	}

	public void setListaCpf(Set<Long> listaCpf) {
		this.listaCpf = listaCpf;
	}

}
