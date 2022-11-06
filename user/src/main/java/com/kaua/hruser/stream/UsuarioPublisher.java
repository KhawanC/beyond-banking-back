package com.kaua.hruser.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.kaua.hruser.model.Usuario;

@Component
public class UsuarioPublisher {

	@Autowired
	KafkaTemplate<String, Usuario> usuarioTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioPublisher.class);
	
	public void saveUsuario(Usuario usuario) throws Exception{
		
		try {
			usuarioTemplate.send("usuario.save", usuario);
			log.info("O tópico para salvar usuário foi enviado!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Houve um erro ao enviar o tópico de usuário!");
		}
		
	}
	
}
