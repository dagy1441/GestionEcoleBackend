package com.gestion.gestionecole.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.gestionecole.exception.ResourceNotFoundException;
import com.gestion.gestionecole.models.AnneeScolaire;
import com.gestion.gestionecole.service.implement.AnneeScolaireService;

@RestController
@RequestMapping("/api/v1")
public class AnneeScolaireController {

	@Autowired
	AnneeScolaireService anneeScolaireService;

	@PostMapping("/anneeScolaires")
	public AnneeScolaire createAnneeScolaire(@Valid @RequestBody AnneeScolaire anneeScolaire) {
		return anneeScolaireService.save(anneeScolaire);
	}
	
	@PutMapping("/anneeScolaire/{id}")
	public ResponseEntity<AnneeScolaire> updateAnneeScolaire(
			@PathVariable(value = "id") Long idAnneeScolaire,
			@Valid @RequestBody AnneeScolaire anneeScolaireDetails) throws ResourceNotFoundException {
		
		AnneeScolaire anneeScolaire = anneeScolaireService.readOne(idAnneeScolaire)
				.orElseThrow(()-> new ResourceNotFoundException("L'annee scolaire " + idAnneeScolaire + " n'existe pas "));
		
		anneeScolaire.setDateDebut(anneeScolaireDetails.getDateDebut());
		anneeScolaire.setDateFin(anneeScolaireDetails.getDateFin());
		anneeScolaire.setLibelle(anneeScolaireDetails.getLibelle());
		
		final AnneeScolaire updatedAnneeScolaire = anneeScolaireService.update(anneeScolaire);
		
		return ResponseEntity.ok(updatedAnneeScolaire);

	}

	@GetMapping("/anneeScolaires")
	public List<AnneeScolaire> getAllAnneeScolaire(){
		return anneeScolaireService.readAll();
	}

	@GetMapping("/anneeScolaires/{id}")
	public ResponseEntity<AnneeScolaire> getAnneeScolaireById(
			@PathVariable(value = "id") Long idAnneeScolaire)throws ResourceNotFoundException{
		
		AnneeScolaire anneeScolaire = anneeScolaireService.readOne(idAnneeScolaire)
				.orElseThrow(()-> new ResourceNotFoundException("L'annee scolaire " + idAnneeScolaire + " n'existe pas "));
		
		return ResponseEntity.ok().body(anneeScolaire);
		
	}

	@DeleteMapping("/anneeScolaire/{id}")
	public Map<String, Boolean> deleteAnneeScolaire(
			@PathVariable(value = "id") Long idAnneeScolaire) throws ResourceNotFoundException{
		
		AnneeScolaire anneeScolaire = anneeScolaireService.readOne(idAnneeScolaire)
				.orElseThrow(()-> new ResourceNotFoundException("L'annee scolaire " + idAnneeScolaire + " n'existe pas "));
		
		anneeScolaireService.delete(anneeScolaire);
		
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
		
	}
	
	@GetMapping("/countAnneeScolaire")
	public Integer countAnneeScolaire() {
		return anneeScolaireService.count();
	}
	
}
