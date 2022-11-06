package com.kaua.hruser.stream;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaua.hruser.model.Usuario;
import com.kaua.hruser.service.UsuarioService;

@Component
public class UsuarioListener {
	
	@Autowired
	UsuarioService service;
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioListener.class);

	@KafkaListener(topics = { "usuario.save" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void UsuarioSaveConsumer(ConsumerRecord<String, Usuario> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Usuario form = mapper.convertValue(message.value(), Usuario.class);
			service.save(form);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}
	
	@KafkaListener(topics = { "usuario.update" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void UsuarioUpdateConsumer(ConsumerRecord<String, Usuario> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Usuario form = mapper.convertValue(message.value(), Usuario.class);
			service.update(form);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}
	
	@KafkaListener(topics = { "usuario.delete" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void UsuarioDeleteConsumer(ConsumerRecord<String, Long> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Long id = mapper.convertValue(message.value(), Long.class);
			service.delete(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}
}
