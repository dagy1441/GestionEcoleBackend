package com.gestion.gestionecole.service;

import java.util.List;

import com.gestion.gestionecole.models.Eleve;

public interface IEleveService extends IService<Eleve, Long>{

	public List<Eleve> findByMatricule(String matricule);
	
	public List<Eleve> findByNom(String nom);
	
	public List<Eleve> findByPrenom(String prenom);
	
}
