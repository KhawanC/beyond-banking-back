package com.kaua.hruser.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.kaua.hruser.model.Contato;

@Component
public class ContatoPublisher {

	@Autowired
	KafkaTemplate<String, Contato> contatoTemplate;

	private static final Logger log = LoggerFactory.getLogger(ContatoPublisher.class);

	public void saveContato(Contato contato) throws Exception {

		try {
			contatoTemplate.send("contato.save", contato);
			log.info("O tópico para salvar contato foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de contato!");
		}

	}

}
