package com.kaua.hruser.stream;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaua.hruser.model.Instituicao;
import com.kaua.hruser.service.InstituicaoService;

@Component
public class InstituicaoListener {
	
	@Autowired
	InstituicaoService service;
	
	private static final Logger log = LoggerFactory.getLogger(InstituicaoListener.class);

	@KafkaListener(topics = { "instituicao.save" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void InstituicaoSaveConsumer(ConsumerRecord<String, Instituicao> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Instituicao form = mapper.convertValue(message.value(), Instituicao.class);
			service.save(form);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}
	
	@KafkaListener(topics = { "instituicao.update" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void InstituicaoUpdateConsumer(ConsumerRecord<String, Instituicao> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Instituicao form = mapper.convertValue(message.value(), Instituicao.class);
			service.update(form);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}
	
	@KafkaListener(topics = { "instituicao.delete" }, groupId = "bynd-banking", containerFactory = "kafkaListenerContainerFactory")
	public void InstituicaoDeleteConsumer(ConsumerRecord<String, Long> message) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Long id = mapper.convertValue(message.value(), Long.class);
			service.delete(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}
}
