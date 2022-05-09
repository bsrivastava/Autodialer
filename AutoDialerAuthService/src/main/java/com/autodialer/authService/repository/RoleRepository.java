package com.autodialer.authService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autodialer.authService.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
