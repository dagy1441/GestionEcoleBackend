package com.gestion.gestionecole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{

}
