package bynd.banking.servico.form;

import java.math.BigDecimal;

public class ExtratoForm {

	private Long cpfRemetente;

	private BigDecimal saldo;

	private String descricao;

	public ExtratoForm() {
	}

	public ExtratoForm(Long cpfRemetente, BigDecimal saldo, String descricao) {
		this.cpfRemetente = cpfRemetente;
		this.saldo = saldo;
		this.descricao = descricao;
	}

	public Long getCpfRemetente() {
		return cpfRemetente;
	}

	public void setCpfRemetente(Long cpfRemetente) {
		this.cpfRemetente = cpfRemetente;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
