package com.kaua.hruser.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.kaua.hruser.model.Instituicao;

@Component
public class InstituicaoPublisher {

	@Autowired
	KafkaTemplate<String, Instituicao> instituicaoTemplate;

	@Autowired
	KafkaTemplate<String, Long> idTemplate;

	private static final Logger log = LoggerFactory.getLogger(InstituicaoPublisher.class);

	public void saveInstituicao(Instituicao instituicao) throws Exception {

		try {
			instituicaoTemplate.send("instituicao.save", instituicao);
			log.info("O tópico para salvar responsavel foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de responsavel!");
		}

	}

	public void updateInstituicao(Instituicao instituicao) throws Exception {

		try {
			instituicaoTemplate.send("instituicao.update", instituicao);
			log.info("O tópico para atualizar instituicao foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de instituicao!");
		}

	}

	public void deleteInstituicao(Long id) throws Exception {

		try {
			idTemplate.send("instituicao.delete", id);
			log.info("O tópico para deletar instituicao foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de instituicao!");
		}

	}

}
