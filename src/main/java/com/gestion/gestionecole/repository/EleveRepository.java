package com.gestion.gestionecole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.Eleve;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Long>{

}