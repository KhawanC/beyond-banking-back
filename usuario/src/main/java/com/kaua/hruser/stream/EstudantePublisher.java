package com.kaua.hruser.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.kaua.hruser.model.Estudante;

@Component
public class EstudantePublisher {

	@Autowired
	KafkaTemplate<String, Estudante> estudanteTemplate;

	@Autowired
	KafkaTemplate<String, Long> idTemplate;

	private static final Logger log = LoggerFactory.getLogger(EstudantePublisher.class);

	public void saveEstudante(Estudante estudante) throws Exception {

		try {
			estudanteTemplate.send("estudante.save", estudante);
			log.info("O tópico para salvar estudante foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de estudante!");
		}

	}

	public void updateEstudante(Estudante estudante) throws Exception {

		try {
			estudanteTemplate.send("estudante.update", estudante);
			log.info("O tópico para atualizar estudante foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de estudante!");
		}

	}

	public void deleteEstudante(Long id) throws Exception {

		try {
			idTemplate.send("estudante.delete", id);
			log.info("O tópico para deletar estudante foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de estudante!");
		}

	}

}
