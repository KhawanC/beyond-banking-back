package com.kaua.hruser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaua.hruser.model.Responsavel;
import com.kaua.hruser.model.Usuario;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

	Optional<Responsavel> findByUsuario(Usuario usuario);
}
