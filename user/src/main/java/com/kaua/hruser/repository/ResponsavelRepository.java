package com.kaua.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaua.hruser.model.Responsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

}
