package com.gestion.gestionecole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{
	public AppUser findByUserName(String username);
}
