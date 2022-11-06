package bynd.banking.servico.form;

public class GanhadorAtividadeForm {

	private String nomeAtividade;

	private Long cpfGanhador;

	public GanhadorAtividadeForm() {
	}

	public GanhadorAtividadeForm(String nomeAtividade, Long cpfGanhador) {
		this.nomeAtividade = nomeAtividade;
		this.cpfGanhador = cpfGanhador;
	}

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}

	public Long getCpfGanhador() {
		return cpfGanhador;
	}

	public void setCpfGanhador(Long cpfGanhador) {
		this.cpfGanhador = cpfGanhador;
	}

}
