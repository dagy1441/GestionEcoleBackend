package com.gestion.gestionecole.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.gestion.gestionecole.models.Eleve;
import com.gestion.gestionecole.models.Inscription;
import com.gestion.gestionecole.service.implement.AnneeClasseService;
import com.gestion.gestionecole.service.implement.EleveService;
import com.gestion.gestionecole.service.implement.InscriptionService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class InscriptionController {
	
	@Autowired InscriptionService inscriptionService;
	@Autowired EleveService eleveService;
	@Autowired AnneeClasseService anneeClasseService;
	
	@PostMapping("/inscriptions/{idEleve}/{idAnnee}")
	public Inscription createInscription(
			@Valid @RequestBody Inscription inscription,
			@PathVariable Long idEleve, @PathVariable Long idAnnee) 
			throws ResourceNotFoundException {
		
		Eleve eleve = eleveService.readOne(idEleve).orElseThrow(
				()-> new ResourceNotFoundException("L'eleve "+idEleve+" invalide")
				);
		
		AnneeClasse anneeClasse = anneeClasseService.readOne(idAnnee).orElseThrow(
				()-> new ResourceNotFoundException("L'annee Classe "+idAnnee+" invalide")
				);
		
		inscription.setEleve(eleve);
		inscription.setAnneeClasse(anneeClasse);
				
		return inscriptionService.save(inscription);
	}
	
	@PutMapping("/inscriptions/{id}")
	public ResponseEntity<Inscription> updateInscription(
			@PathVariable(value = "id") Long idInscription,
			@Valid @RequestBody Inscription detailInscription)
			throws ResourceNotFoundException{
		
		Inscription inscription = inscriptionService.readOne(idInscription).orElseThrow(
				()-> new ResourceNotFoundException("l'inscription "+idInscription+" n'existe pas")				
				);
		
		inscription.setIdAnneeInscription(detailInscription.getIdAnneeInscription());
		inscription.setFicheInscriptionEnLigne(detailInscription.getFicheInscriptionEnLigne());
		inscription.setFicheInscriptionEnPresence(detailInscription.getFicheInscriptionEnPresence());
		inscription.setFicheAttestationBEPC(detailInscription.getFicheAttestationBEPC());
		inscription.setFicheAttestationBT(detailInscription.getFicheAttestationBT());
		inscription.setFicheAttestationCAP(detailInscription.getFicheAttestationCAP());
		inscription.setDernierBulletin(detailInscription.getDernierBulletin());
		
		final Inscription updatedInscription = inscriptionService.update(inscription);
		
		return ResponseEntity.ok(updatedInscription);
	}
	
	@GetMapping("/inscriptions/{idInscription}")
	public ResponseEntity<Inscription> getInscriptionById(
			@PathVariable Long idInscription) throws ResourceNotFoundException{
		
		Inscription inscription = inscriptionService.readOne(idInscription).orElseThrow(
				()-> new ResourceNotFoundException("l'inscription "+idInscription+" n'existe pas")				
				);
		
		return ResponseEntity.ok().body(inscription);
	}
	
	@DeleteMapping("/inscriptions/{id}")
	public Map<String, Boolean> deleteInscription(@PathVariable Long idInscription) throws ResourceNotFoundException{
		
		Inscription inscription = inscriptionService.readOne(idInscription).orElseThrow(
				()-> new ResourceNotFoundException("l'inscription "+idInscription+" n'existe pas")				
				);
		inscriptionService.delete(inscription);
		
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
	}
	
	@GetMapping("/inscriptions")
	public List<Inscription> getAllInscription(){
		return inscriptionService.readAll();
	}
	
	@GetMapping("/countInscription")
	public Long countAllInscription() {
		return inscriptionService.count();
	}

}
