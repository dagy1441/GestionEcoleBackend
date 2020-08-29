package com.gestion.gestionecole.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.Eleve;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Long>{

	public List<Eleve> findByMatricule(String matricule);
	
	public List<Eleve> findByNom(String nom);
	
	public List<Eleve> findByPrenom(String prenom);
	
	
	
}
