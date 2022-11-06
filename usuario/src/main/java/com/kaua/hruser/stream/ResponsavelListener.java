package com.kaua.hruser.stream;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaua.hruser.model.Responsavel;
import com.kaua.hruser.service.ResponsavelService;

@Component
public class ResponsavelListener {
	
	@Autowired
	ResponsavelService service;
	
	private static final Logger log = LoggerFactory.getLogger(ResponsavelListener.class);

	@KafkaListener(topics = { "responsavel.save" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void ResponsavelSaveConsumer(ConsumerRecord<String, Responsavel> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Responsavel form = mapper.convertValue(message.value(), Responsavel.class);
			service.save(form);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}
	
	@KafkaListener(topics = { "responsavel.update" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void ResponsavelUpdateConsumer(ConsumerRecord<String, Responsavel> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Responsavel form = mapper.convertValue(message.value(), Responsavel.class);
			service.update(form);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}
	
	@KafkaListener(topics = { "responsavel.delete" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void ResponsavelDeleteConsumer(ConsumerRecord<String, Long> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Long id = mapper.convertValue(message.value(), Long.class);
			service.delete(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}
}
