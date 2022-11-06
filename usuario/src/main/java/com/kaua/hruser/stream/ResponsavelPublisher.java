package com.kaua.hruser.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.kaua.hruser.model.Responsavel;

@Component
public class ResponsavelPublisher {

	@Autowired
	KafkaTemplate<String, Responsavel> responsavelTemplate;

	@Autowired
	KafkaTemplate<String, Long> idTemplate;

	private static final Logger log = LoggerFactory.getLogger(ResponsavelPublisher.class);

	public void saveResponsavel(Responsavel responsavel) throws Exception {

		try {
			responsavelTemplate.send("contato.save", responsavel);
			log.info("O tópico para salvar responsavel foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de responsavel!");
		}

	}

	public void updateResponsavel(Responsavel responsavel) throws Exception {

		try {
			responsavelTemplate.send("contato.update", responsavel);
			log.info("O tópico para atualizar responsavel foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de responsavel!");
		}

	}

	public void deleteResponsavel(Long id) throws Exception {

		try {
			idTemplate.send("contato.delete", id);
			log.info("O tópico para deletar responsavel foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de responsavel!");
		}

	}

}
