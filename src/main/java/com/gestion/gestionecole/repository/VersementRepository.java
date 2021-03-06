package com.gestion.gestionecole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.Versement;

@Repository
public interface VersementRepository extends JpaRepository<Versement, Long>{

}
