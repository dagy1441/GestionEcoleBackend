package com.gestion.gestionecole.service;

import java.util.List;
import java.util.Optional;

import com.gestion.gestionecole.models.Eleve;

public interface IEleveService extends IService<Eleve, Long>{

	public Optional<Eleve> findByMatricule(String matricule);
	
	public List<Eleve> findByNom(String nom);
		
	public List<Eleve> findByPrenom(String prenom);

	//public List<Eleve> findByNomLike( String nom);
	
	//public List<Eleve> findByPrenomLike(String prenom);
	
	public List<Eleve> findByNomLikeOrPrenomLike(String nom, String prenom );
	
}
