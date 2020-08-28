package com.gestion.gestionecole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.TypeVersement;

@Repository
public interface TypeVersementRepository extends JpaRepository<TypeVersement, Long>{

}
