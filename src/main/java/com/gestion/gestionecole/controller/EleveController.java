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
	
	@GetMapping("/eleves/{id}")
	public ResponseEntity<Eleve> getEleveById(
			@PathVariable(value = "id") Long idEleve)
			throws ResourceNotFoundException{
		
		Eleve eleve = eleveService.readOne(idEleve)
				.orElseThrow( ()-> new ResourceNotFoundException( "L'eleve " +idEleve+" n'existe pas" ) );
	
		return ResponseEntity.ok().body(eleve);
	}
	
	@GetMapping("/eleves/matricule/{matricule}")
	public ResponseEntity<Eleve> getEleveByMatricule(
			@PathVariable(value = "matricule") String matriculeEleve)throws ResourceNotFoundException{
		
		Eleve eleve = eleveService.findByMatricule(matriculeEleve).orElseThrow(
				()-> new ResourceNotFoundException( "L'eleve " +matriculeEleve+" n'existe pas" ) );
		
		return ResponseEntity.ok().body(eleve);
	}
	
	@GetMapping("/eleves/rechercher/{searchNomOrPrenom}")
	public List<Eleve> getEleveByNomOrPrenom(
			@PathVariable String searchNomOrPrenom)throws ResourceNotFoundException{
		
		 List<Eleve> eleves = eleveService.findByNomLikeOrPrenomLike(searchNomOrPrenom, searchNomOrPrenom);
		
		return eleves;
	}
	
	
	@DeleteMapping("/eleves/{id}")
	public Map<String, Boolean> deleteEleve(@PathVariable(value = "id") Long idEleve)throws ResourceNotFoundException{
		
		Eleve eleve = eleveService.readOne(idEleve)
				.orElseThrow( ()-> new ResourceNotFoundException( "L'eleve " +idEleve+" n'existe pas" ) );
	
		eleveService.delete(eleve);
		
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
	
	}
	
	@GetMapping("/eleves")
	public List<Eleve> getAllEleves(){
		return eleveService.readAll();
	}
	
	@GetMapping("/countEleve")
	public Long countAllEleve() {
		return eleveService.count();
	}
	
}
