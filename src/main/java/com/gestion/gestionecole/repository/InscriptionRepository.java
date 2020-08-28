package com.gestion.gestionecole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.Inscription;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long>{

}
