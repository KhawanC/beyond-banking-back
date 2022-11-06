package com.kaua.hroauth.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kaua.hroauth.userDTO.UsuarioDTO;

@Component
@FeignClient(name = "bynd-usuario", path = "/usuario")
public interface UserFeignClient {

	@GetMapping(value = "/byEmail")
	ResponseEntity<UsuarioDTO> findByEmail(@RequestParam String email);
}
