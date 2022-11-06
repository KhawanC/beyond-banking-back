package com.kaua.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaua.hruser.model.InstituicaoEnsino;

@Repository
public interface InstituicaoEnsinoRepository extends JpaRepository<InstituicaoEnsino, Long>{

}
