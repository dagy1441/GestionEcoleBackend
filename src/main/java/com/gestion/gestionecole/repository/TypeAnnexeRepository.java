package com.gestion.gestionecole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.TypeAnnexe;

@Repository
public interface TypeAnnexeRepository extends JpaRepository<TypeAnnexe, Long> {

}
