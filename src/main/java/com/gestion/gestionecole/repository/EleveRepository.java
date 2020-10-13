package com.gestion.gestionecole.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestion.gestionecole.models.Eleve;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Long>{

	public Optional<Eleve> findByMatricule(String matricule);
	
	public List<Eleve> findByNom(String nom);
		
	public List<Eleve> findByPrenom(String prenom);
	
	@Query("SELECT e FROM Eleve e WHERE e.nom LIKE %:nom% OR e.prenom LIKE %:prenom%" )
	public List<Eleve> findByNomLikeOrPrenomLike(@Param("nom") String nom,
			@Param("prenom") String prenom );
	
//	@Query("SELECT e FROM Eleve e WHERE e.prenom LIKE %:prenom%")
//	public List<Eleve> findByPrenomLike(@Param("prenom") String prenom);

//	@Query("SELECT e FROM Eleve e WHERE e.nom LIKE %:nom%")
//	public List<Eleve> findByPrenomLike(@Param("nom") String nom);
	
	
	
}
