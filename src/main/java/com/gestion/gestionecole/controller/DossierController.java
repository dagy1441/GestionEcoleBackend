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
import com.gestion.gestionecole.models.Dossier;
import com.gestion.gestionecole.service.implement.DossierService;

@RestController
@RequestMapping("/api/v1")
public class DossierController {
	
	@Autowired DossierService dossierService;
	
	@PostMapping("/dossiers")
	public Dossier createDossier(@Valid @RequestBody Dossier dossier) {
		return dossierService.save(dossier);
	}
	
	@PutMapping("/dossier/{id}")
	public ResponseEntity<Dossier> updateDossier(
			@PathVariable(value = "id") Long idDossier,
			@Valid @RequestBody Dossier dossierDetails) throws ResourceNotFoundException{
		
		Dossier dossier = dossierService.readOne(idDossier)
				.orElseThrow(()-> new ResourceNotFoundException("Le dossier" + idDossier + " n'existe pas "));
		
		dossier.setEtat(dossierDetails.getEtat());
		
		final Dossier updatedDossier = dossierService.update(dossier);
		
		return ResponseEntity.ok(updatedDossier);
		
	}
	
	@GetMapping("/dossiers")
	public List<Dossier> getAllDossiers(){
		return dossierService.readAll();
	}
	
	@GetMapping("/dossiers/{id}")
	public ResponseEntity<Dossier>  getDossierById(
			@PathVariable(value = "id") Long idDossier)throws ResourceNotFoundException{
		
		Dossier dossier = dossierService.readOne(idDossier)
				.orElseThrow(()-> new ResourceNotFoundException("Le dossier" + idDossier + " n'existe pas "));
		
		return ResponseEntity.ok().body(dossier);
		
	}
	
	@DeleteMapping("/dossier/{id}")
	public Map<String, Boolean> deleteDossier(
			@PathVariable(value = "id") Long idDossier) throws ResourceNotFoundException{
		
		Dossier dossier = dossierService.readOne(idDossier)
				.orElseThrow(()-> new ResourceNotFoundException("Le dossier" + idDossier + " n'existe pas "));
		
		dossierService.delete(dossier);
		
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
	}
	
	@GetMapping("/countDossier")
	public Integer countDossier() {
		return dossierService.count();
	}

}
