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
import com.gestion.gestionecole.models.Annexe;
import com.gestion.gestionecole.service.implement.AnnexeService;

@RestController
@RequestMapping("/api/v1")
public class AnnexeController {

	@Autowired AnnexeService annexeService;
	
	@PostMapping("/annexes")
	public Annexe createAnnexe( @Valid @RequestBody Annexe annexe) {
		return annexeService.save(annexe);
	}
	
	@PutMapping("/annexes/{id}")
	public ResponseEntity<Annexe> updateAnnexe(
			@PathVariable(value = "id") Long idAnnexe,
			@Valid @RequestBody Annexe annexeDetails)
			throws ResourceNotFoundException{
		
		Annexe annexe = annexeService.readOne(idAnnexe).orElseThrow(
				()-> new ResourceNotFoundException("L'annexe" + idAnnexe + " n'existe pas "));
		
		annexe.setEtat(annexeDetails.getEtat());
		
		final Annexe updatedAnnexe = annexeService.update(annexe);
		
		return ResponseEntity.ok(updatedAnnexe);
		
	}
	
	@GetMapping("/annexes/{id}")
	public ResponseEntity<Annexe> getAnnexeById(
			@PathVariable(value = "id") Long idAnnexe) throws ResourceNotFoundException{
		
		Annexe annexe = annexeService.readOne(idAnnexe).orElseThrow(
				()-> new ResourceNotFoundException("L'annexe" + idAnnexe + " n'existe pas "));
		
		return ResponseEntity.ok().body(annexe);	
	}
	
	@DeleteMapping("/annexes/{id}")
	public Map<String, Boolean> deleteAnnexe(
			@PathVariable(value = "id") Long idAnnexe) throws ResourceNotFoundException{
		
		Annexe annexe = annexeService.readOne(idAnnexe).orElseThrow(
				()-> new ResourceNotFoundException("L'annexe" + idAnnexe + " n'existe pas "));
		
		annexeService.delete(annexe);
		
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
	}
	
	@GetMapping("/annexes")
	public List<Annexe> getAllAnnexe(){
		return annexeService.readAll();
	}
	
	@GetMapping("/countAnnexe")
	public Long countAllAnnexe() {
		return annexeService.count();
	}
}
