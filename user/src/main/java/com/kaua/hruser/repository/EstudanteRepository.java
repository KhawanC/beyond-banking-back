package com.kaua.hruser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaua.hruser.model.Estudante;
import com.kaua.hruser.model.Usuario;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

	Optional<Estudante> findByUsuario(Usuario usuario);
}
