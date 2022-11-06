package com.kaua.hruser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaua.hruser.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

	Optional<Contato> findByCep(Integer cep);
	Optional<Contato> findByCidade(String cidade);
}
