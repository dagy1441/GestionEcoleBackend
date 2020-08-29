package com.gestion.gestionecole.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.gestionecole.exception.ResourceNotFoundException;
import com.gestion.gestionecole.models.Eleve;
import com.gestion.gestionecole.service.implement.EleveService;

@RestController
@RequestMapping("/api/v1")
public class EleveController {

	@Autowired EleveService eleveService;
	
	@PostMapping("/eleves")
	public Eleve createEleve(@Valid @RequestBody Eleve eleve) {
		return eleveService.save(eleve);
	}
	
	@PutMapping("/eleves/{id}")
	public ResponseEntity<Eleve> updateEleve(
			@PathVariable(value = "id") Long idEleve,
			@Valid @RequestBody Eleve eleveDetails)
			throws ResourceNotFoundException{
		
		Eleve eleve = eleveService.readOne(idEleve)
				.orElseThrow( ()-> new ResourceNotFoundException( "L'eleve " +idEleve+" n'existe pas" ) );
		
		eleve.setMatricule(eleveDetails.getMatricule());
		eleve.setNom(eleveDetails.getNom());
		eleve.setPrenom(eleveDetails.getPrenom());
		eleve.setDateDeNaissance(eleve.getDateDeNaissance());
		eleve.setLieuDeNaissance(eleveDetails.getLieuDeNaissance());
		eleve.setSexe(eleveDetails.getSexe());
		
		final Eleve updatedEleve = eleveService.update(eleve);
		
		return ResponseEntity.ok(updatedEleve);
		
	}
}
