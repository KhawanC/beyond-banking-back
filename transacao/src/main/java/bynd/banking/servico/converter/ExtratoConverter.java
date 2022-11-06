package bynd.banking.servico.converter;

import java.util.Date;

import org.springframework.stereotype.Component;

import bynd.banking.servico.form.ExtratoForm;
import bynd.banking.servico.model.Extrato;

@Component
public class ExtratoConverter {

	public Extrato ExtratoFormToExtrato(ExtratoForm form) {
		Extrato model = new Extrato();
		
		model.setCpfRemetente(form.getCpfRemetente());
		model.setDescricao(form.getDescricao());
		model.setHorarioTransacao(new Date());
		model.setSaldo(form.getSaldo());
		
		return model;
	}
}
