package com.kaua.hruser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaua.hruser.enums.RoleEnum;
import com.kaua.hruser.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(RoleEnum roleName);
}
