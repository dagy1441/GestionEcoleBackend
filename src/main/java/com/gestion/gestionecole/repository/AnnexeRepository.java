package com.gestion.gestionecole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.Annexe;

@Repository
public interface AnnexeRepository extends JpaRepository<Annexe, Long>{

}
