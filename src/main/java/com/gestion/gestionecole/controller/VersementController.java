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
import com.gestion.gestionecole.models.Versement;
import com.gestion.gestionecole.service.implement.VersementService;

@RestController
@RequestMapping("/api/v1")
public class VersementController {

	@Autowired VersementService versementService;
	
	@PostMapping("/versements")
	public Versement createVersement(@Valid @RequestBody Versement versement) {
		return versementService.save(versement);
	}
	
	@PutMapping ("/versements/{id}")
	public ResponseEntity<Versement> updateVersement(
			@PathVariable(value = "id") Long idVersement,
			@Valid @RequestBody Versement versementDetails) throws ResourceNotFoundException{
		
		Versement versement = versementService.readOne(idVersement)
				.orElseThrow( ()-> new ResourceNotFoundException( "Le versement " + idVersement + "n'existe pas") );
		
		versement.setMontant(versementDetails.getMontant());
		versement.setDateEchean(versementDetails.getDateEchean());
		versement.setDateVersement(versementDetails.getDateVersement());
		versement.setMoisRegler(versementDetails.getMoisRegler());
		
		final Versement updatedVersement = versementService.update(versement);
		
		return ResponseEntity.ok(updatedVersement);
		
	}
	
	@GetMapping("/versements/{id}")
	public ResponseEntity<Versement> getVersementById(
			@PathVariable(value = "id") Long idVersement)
			throws ResourceNotFoundException{
		
		Versement versement = versementService.readOne(idVersement)
				.orElseThrow( ()-> new ResourceNotFoundException( "Le versement " + idVersement + "n'existe pas") );
		
		return ResponseEntity.ok().body(versement);
		
	}
	
	@DeleteMapping("/versements/{id}")
	public Map<String, Boolean> deleteVersement(
			@PathVariable(value = "id") Long idVersement)
			throws ResourceNotFoundException {
		
		Versement versement = versementService.readOne(idVersement)
				.orElseThrow( ()-> new ResourceNotFoundException( "Le versement " + idVersement + "n'existe pas") );
		
		versementService.delete(versement);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);

		return response;
		
	}
	
	@GetMapping("/versements")
	public List<Versement> getAllVersements(){
		return versementService.readAll();
	}
	
	@GetMapping("/countVersement")
	public Long countAllVersement() {
		return versementService.count();
	}
	
}
