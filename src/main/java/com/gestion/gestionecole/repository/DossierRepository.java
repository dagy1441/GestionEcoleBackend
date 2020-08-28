package com.gestion.gestionecole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.Dossier;

@Repository
public interface DossierRepository extends JpaRepository<Dossier, Long>{

}
