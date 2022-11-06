package com.kaua.hroauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kaua.hroauth.feignClient.UserFeignClient;
import com.kaua.hroauth.userDTO.UsuarioDTO;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserFeignClient userFeignClient;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UsuarioDTO user = userFeignClient.findByEmail(email).getBody();
		if (user == null) {
			throw new UsernameNotFoundException("Email not found");
		}
		return user;
	}
}
