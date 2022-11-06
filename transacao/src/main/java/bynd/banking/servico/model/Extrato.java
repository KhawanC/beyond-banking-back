package bynd.banking.servico.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "extrato")
public class Extrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "horario_transacao")
	private Date horarioTransacao;

	@Column(name = "cpf_remetente")
	private Long cpfRemetente;

	@Column(name = "saldo")
	private BigDecimal saldo;

	@Column(name = "descricao")
	private String descricao;

	public Extrato() {
	}

	public Extrato(Long id, Date horarioTransacao, Long cpfRemetente, BigDecimal saldo, String descricao) {
		this.id = id;
		this.horarioTransacao = horarioTransacao;
		this.cpfRemetente = cpfRemetente;
		this.saldo = saldo;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHorarioTransacao() {
		return horarioTransacao;
	}

	public void setHorarioTransacao(Date horarioTransacao) {
		this.horarioTransacao = horarioTransacao;
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
