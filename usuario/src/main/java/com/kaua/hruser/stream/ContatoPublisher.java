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
	@Autowired
	KafkaTemplate<String, Long> idTemplate;

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
	
	public void updateContato(Contato contato) throws Exception {
		
		try {
			contatoTemplate.send("contato.update", contato);
			log.info("O tópico para atualizar contato foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de contato!");
		}
		
	}
	
	public void deleteContato(Long id) throws Exception {
		
		try {
			idTemplate.send("contato.delete", id);
			log.info("O tópico para deletar contato foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de contato!");
		}
		
	}

}
