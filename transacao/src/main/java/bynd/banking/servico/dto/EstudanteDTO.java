package bynd.banking.servico.dto;

public class EstudanteDTO {

	private Long id;

	private Integer pontosAtividades;

	private Boolean isTranferenciaAutorizada;

	public EstudanteDTO() {
	}

	public EstudanteDTO(Long id, Integer pontosAtividades, Boolean isTranferenciaAutorizada) {
		this.id = id;
		this.pontosAtividades = pontosAtividades;
		this.isTranferenciaAutorizada = isTranferenciaAutorizada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPontosAtividades() {
		return pontosAtividades;
	}

	public void setPontosAtividades(Integer pontosAtividades) {
		this.pontosAtividades = pontosAtividades;
	}

	public Boolean getIsTranferenciaAutorizada() {
		return isTranferenciaAutorizada;
	}

	public void setIsTranferenciaAutorizada(Boolean isTranferenciaAutorizada) {
		this.isTranferenciaAutorizada = isTranferenciaAutorizada;
	}

}
