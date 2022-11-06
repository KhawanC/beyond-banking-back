package com.kaua.hruser.stream;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaua.hruser.model.Contato;
import com.kaua.hruser.service.ContatoService;

@Component
public class ContatoListener {
	
	@Autowired
	ContatoService service;
	
	private static final Logger log = LoggerFactory.getLogger(ContatoListener.class);

	@KafkaListener(topics = { "contato.save" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void UsuarioModelConsumer(ConsumerRecord<String, Contato> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Contato form = mapper.convertValue(message.value(), Contato.class);
			service.save(form);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}
}
