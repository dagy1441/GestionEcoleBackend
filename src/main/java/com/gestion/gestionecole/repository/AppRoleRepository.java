package com.gestion.gestionecole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.AppRole;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long>{
	public AppRole findByRoleName(String roleName);
}
