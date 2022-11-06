package com.kaua.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaua.hruser.model.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
