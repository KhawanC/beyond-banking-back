package com.kaua.hruser.stream;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaua.hruser.model.Estudante;
import com.kaua.hruser.service.EstudanteService;

@Component
public class EstudanteListener {
	
	@Autowired
	EstudanteService service;
	
	private static final Logger log = LoggerFactory.getLogger(EstudanteListener.class);

	@KafkaListener(topics = { "estudante.save" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void EstudanteSaveConsumer(ConsumerRecord<String, Estudante> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Estudante form = mapper.convertValue(message.value(), Estudante.class);
			service.save(form);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}
	
	@KafkaListener(topics = { "estudante.update" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void EstudanteUpdateConsumer(ConsumerRecord<String, Estudante> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Estudante form = mapper.convertValue(message.value(), Estudante.class);
			service.update(form);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}
	
	@KafkaListener(topics = { "estudante.delete" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void EstudanteDeleteConsumer(ConsumerRecord<String, Long> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Long id = mapper.convertValue(message.value(), Long.class);
			service.delete(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}
}
