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
import com.gestion.gestionecole.models.TypeVersement;
import com.gestion.gestionecole.service.implement.TypeVersementService;

@RestController
@RequestMapping("/api/v1")
public class TypeVersementController {

	@Autowired TypeVersementService typeVersementService;
	
	@PostMapping("/typeVersements")
	public TypeVersement createTypeVersement(@Valid @RequestBody TypeVersement typeVersement) {
		return typeVersementService.save(typeVersement);
	}
	
	@PutMapping("/typeVersements/{id}")
	public ResponseEntity<TypeVersement> updateTypeVersement(
			@PathVariable(value = "id") Long idTypeVersement,
			@RequestBody TypeVersement typeVersementDetails)
			throws ResourceNotFoundException{
		
		TypeVersement typeVersement = typeVersementService.readOne(idTypeVersement)
				.orElseThrow( ()-> new ResourceNotFoundException( "Le type de versement " + idTypeVersement + " n'existe pas" ) );
		
		typeVersement.setLibelleTypeVersement(typeVersementDetails.getLibelleTypeVersement());
		
		final TypeVersement updatedTypeVersement = typeVersementService.update(typeVersement);
		
		return ResponseEntity.ok(updatedTypeVersement);
	}
	
	@GetMapping("/typeVersement/{id}")
	public ResponseEntity<TypeVersement> getTypeVersementById(
			@PathVariable(value = "id") Long idTypeVersement)
			throws ResourceNotFoundException{
		
		TypeVersement typeVersement = typeVersementService.readOne(idTypeVersement)
				.orElseThrow( ()-> new ResourceNotFoundException( "Le type de versement " + idTypeVersement + " n'existe pas" ) );
		
		return ResponseEntity.ok().body(typeVersement);
	}
	
	@DeleteMapping("/typeVersements/{id}")
	public Map<String, Boolean> deleteTypeVersement(
			@PathVariable(value = "id") Long idTypeVersement)
					throws ResourceNotFoundException{
		
		TypeVersement typeVersement = typeVersementService.readOne(idTypeVersement)
				.orElseThrow( ()-> new ResourceNotFoundException( "Le type de versement " + idTypeVersement + " n'existe pas" ) );
	
		typeVersementService.delete(typeVersement);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);

		return response;
		
	}
	
	@GetMapping("/typeVersements")
	public List<TypeVersement> getAllTypeVersement(){
		return typeVersementService.readAll();
	}
	
	@GetMapping("/countVersements")
	public Long countAllTypeVersement() {
		return typeVersementService.count();
	}
	
}
