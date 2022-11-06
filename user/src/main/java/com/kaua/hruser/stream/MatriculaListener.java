package com.kaua.hruser.stream;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaua.hruser.model.Matricula;
import com.kaua.hruser.service.MatriculaService;

@Component
public class MatriculaListener {
	
	@Autowired
	MatriculaService service;
	
	private static final Logger log = LoggerFactory.getLogger(MatriculaListener.class);

	@KafkaListener(topics = { "matricula.save" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void MatriculaSaveConsumer(ConsumerRecord<String, Matricula> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Matricula matricula = mapper.convertValue(message.value(), Matricula.class);
			service.save(matricula);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}
	
	@KafkaListener(topics = { "matricula.update" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void MatriculaUpdateConsumer(ConsumerRecord<String, Matricula> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Matricula form = mapper.convertValue(message.value(), Matricula.class);
			service.update(form);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}
	
	@KafkaListener(topics = { "matricula.delete" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void MatriculaDeleteConsumer(ConsumerRecord<String, Long> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Long id = mapper.convertValue(message.value(), Long.class);
			service.delete(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}
}
