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
import com.gestion.gestionecole.models.TypeDossier;
import com.gestion.gestionecole.service.implement.TypeDossierService;

@RestController
@RequestMapping("/api/v1")
public class TypeDossierController {

	@Autowired TypeDossierService typeDossierService;
	
	@PostMapping("/typeDossiers")
	public TypeDossier create(@Valid @RequestBody TypeDossier typeDossier) {
		return typeDossierService.save(typeDossier);
	}
	
	@PutMapping("/typeDossiers/{id}")
	public ResponseEntity<TypeDossier> updateTypeDossier(
			@PathVariable(value = "id") Long idTypeDossier,
			@Valid @RequestBody TypeDossier typeDossierDetails)
			throws ResourceNotFoundException{
		
		TypeDossier typeDossier = typeDossierService.readOne(idTypeDossier)
				.orElseThrow( ()-> new ResourceNotFoundException("Le type du dossier" + idTypeDossier + " n'existe pas "));
		
		typeDossier.setLibelleTypeDossier(typeDossierDetails.getLibelleTypeDossier());
		
		final TypeDossier updatedTypeDossier = typeDossierService.update(typeDossier);
		
		return ResponseEntity.ok(updatedTypeDossier);
		
	}
	
	@GetMapping("/typeDossiers/{id}")
	public ResponseEntity<TypeDossier> getTypeDossierById(
			@PathVariable(value = "id") Long idTypeDossier)throws ResourceNotFoundException{
		
		TypeDossier typeDossier = typeDossierService.readOne(idTypeDossier)
				.orElseThrow( ()-> new ResourceNotFoundException("Le type du dossier" + idTypeDossier + " n'existe pas "));
		
		return ResponseEntity.ok().body(typeDossier);
	}
	
	@DeleteMapping("/typeDossiers/{id}")
	public Map<String, Boolean> deleteTypeDossier(
			@PathVariable(value = "id") Long idTypeDossier) throws ResourceNotFoundException{
		
		TypeDossier typeDossier = typeDossierService.readOne(idTypeDossier)
				.orElseThrow( ()-> new ResourceNotFoundException("Le type du dossier" + idTypeDossier + " n'existe pas "));
		
		typeDossierService.delete(typeDossier);
		
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
	}
	
	@GetMapping("/typeDossiers")
	public List<TypeDossier> getAllTypeDossier(){
		return typeDossierService.readAll();
	}
	
	@GetMapping("/countTypeDossier")
	public Long countTypeDossier() {
		return typeDossierService.count();
	}
}
