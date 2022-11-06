package com.kaua.hruser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estudante")
public class Estudante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@Column(name = "is_transferencia_autorizado")
	private Boolean isTranferenciaAutorizada;

	public Estudante() {
	}

	public Estudante(Long id, Usuario usuario, Boolean isTranferenciaAutorizada) {
		this.id = id;
		this.usuario = usuario;
		this.isTranferenciaAutorizada = isTranferenciaAutorizada;
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

	public Boolean getIsTranferenciaAutorizada() {
		return isTranferenciaAutorizada;
	}

	public void setIsTranferenciaAutorizada(Boolean isTranferenciaAutorizada) {
		this.isTranferenciaAutorizada = isTranferenciaAutorizada;
	}

}
