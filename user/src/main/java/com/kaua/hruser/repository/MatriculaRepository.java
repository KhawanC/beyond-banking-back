package com.kaua.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaua.hruser.model.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{

}
