package com.gestion.gestionecole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.AnneeClasse;

@Repository
public interface AnneeClasseRepository extends JpaRepository<AnneeClasse, Long>{

}
