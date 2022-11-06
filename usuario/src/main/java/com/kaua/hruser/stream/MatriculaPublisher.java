package com.kaua.hruser.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.kaua.hruser.model.Matricula;

@Component
public class MatriculaPublisher {

	@Autowired
	KafkaTemplate<String, Matricula> matriculaTemplate;
	@Autowired
	KafkaTemplate<String, Long> idTemplate;

	private static final Logger log = LoggerFactory.getLogger(MatriculaPublisher.class);

	public void saveMatricula(Matricula matricula) throws Exception {

		try {
			matriculaTemplate.send("matricula.save", matricula);
			log.info("O tópico para salvar matricula foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de contato!");
		}

	}

	public void updateMatricula(Matricula matricula) throws Exception {

		try {
			matriculaTemplate.send("matricula.update", matricula);
			log.info("O tópico para atualizar contato foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de matricula!");
		}

	}

	public void deleteMatricula(Long id) throws Exception {

		try {
			idTemplate.send("matricula.delete", id);
			log.info("O tópico para deletar matricula foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de matricula!");
		}

	}

}
