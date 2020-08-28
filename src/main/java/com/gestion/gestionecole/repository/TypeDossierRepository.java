package com.gestion.gestionecole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.TypeDossier;

@Repository
public interface TypeDossierRepository extends JpaRepository<TypeDossier, Long> {

}
