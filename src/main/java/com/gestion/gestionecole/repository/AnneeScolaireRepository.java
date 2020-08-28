package com.gestion.gestionecole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.AnneeScolaire;

@Repository
public interface AnneeScolaireRepository extends JpaRepository<AnneeScolaire, Long> {

}
