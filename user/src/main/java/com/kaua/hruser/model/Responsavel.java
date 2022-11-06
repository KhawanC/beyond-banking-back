package com.kaua.hruser.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "responsavel")
public class Responsavel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "responsavel_estudante", joinColumns = @JoinColumn(name = "id_responsavel"), inverseJoinColumns = @JoinColumn(name = "id_estudante"))
	private Set<Estudante> listaDependentes;

	public Responsavel() {
	}

	public Responsavel(Long id, Usuario usuario, Set<Estudante> listaDependentes) {
		this.id = id;
		this.usuario = usuario;
		this.listaDependentes = listaDependentes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Estudante> getListaDependentes() {
		return listaDependentes;
	}

	public void setListaDependentes(Set<Estudante> listaDependentes) {
		this.listaDependentes = listaDependentes;
	}

}
