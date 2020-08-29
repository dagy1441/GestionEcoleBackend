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
import com.gestion.gestionecole.models.AnneeClasse;
import com.gestion.gestionecole.service.implement.AnneeClasseService;

@RestController
@RequestMapping("/api/v1")
public class AnneeClasseController {

	@Autowired
	AnneeClasseService anneeClasseService;

	@PostMapping("/anneeClasses")
	public AnneeClasse createAnneeClasse(@Valid @RequestBody AnneeClasse anneeClasse) {
		return anneeClasseService.save(anneeClasse);
	}

	@PutMapping("/anneeClasses/{id}")
	public ResponseEntity<AnneeClasse> updateAnneeClasse(@PathVariable(value = "id") Long idAnneeClasse,
			@Valid @RequestBody AnneeClasse anneeClasseDetails) throws ResourceNotFoundException {

		AnneeClasse anneeClasse = anneeClasseService.readOne(idAnneeClasse)
				.orElseThrow(() -> new ResourceNotFoundException("L'annee classe " + idAnneeClasse + " n'existe pas "));

		anneeClasse.setMontant(anneeClasseDetails.getMontant());

		final AnneeClasse updatedAnneeClasse = anneeClasseService.update(anneeClasse);

		return ResponseEntity.ok(updatedAnneeClasse);

	}

	@GetMapping("/anneeClasses")
	public List<AnneeClasse> getAllAnneeClasses() {
		return anneeClasseService.readAll();
	}

	@GetMapping("/anneeClasses/{id}")
	public ResponseEntity<AnneeClasse> getAnneeClasseById(
			@PathVariable(value = "id") Long idAnneeClasse)throws ResourceNotFoundException{
		
		AnneeClasse anneeClasse = anneeClasseService.readOne(idAnneeClasse)
				.orElseThrow(()-> new ResourceNotFoundException("L'annee classe " + idAnneeClasse + " n'existe pas "));
		
		return ResponseEntity.ok().body(anneeClasse);
	}

	@DeleteMapping("/anneeClasse/{id}")
	public Map<String, Boolean> deleteAnneeClasse(
			@PathVariable(value = "id") Long idAnneeClasse) throws ResourceNotFoundException{
		
		AnneeClasse anneeClasse = anneeClasseService.readOne(idAnneeClasse)
				.orElseThrow(()-> new ResourceNotFoundException("L'annee classe " + idAnneeClasse + " n'existe pas "));
		
		anneeClasseService.delete(anneeClasse);
		
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;		
	}
	
	@GetMapping("/countAnneeClasse")
	public Integer countAnneeClasse() {
		return anneeClasseService.count();
	}
}
