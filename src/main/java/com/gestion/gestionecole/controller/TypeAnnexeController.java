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
import com.gestion.gestionecole.models.TypeAnnexe;
import com.gestion.gestionecole.service.implement.TypeAnnexeService;

@RestController
@RequestMapping("/api/v1")
public class TypeAnnexeController {

	@Autowired
	TypeAnnexeService typeAnnexeService;

	@PostMapping("/typeAnnexe")
	public TypeAnnexe createTypeAnnexe(@Valid @RequestBody TypeAnnexe typeAnnexe) {
		return typeAnnexeService.save(typeAnnexe);
	}

	@PutMapping("/typeAnnexes/{id}")
	public ResponseEntity<TypeAnnexe> updateTypeAnnexe(
			@PathVariable(value = "id") Long idTypeAnnexe,
			@Valid @RequestBody TypeAnnexe typeAnnexeDetails) throws ResourceNotFoundException {

		TypeAnnexe typeAnnexe = typeAnnexeService.readOne(idTypeAnnexe)
				.orElseThrow(() -> new ResourceNotFoundException("Le type annexe" + idTypeAnnexe + " n'existe pas "));

		typeAnnexe.setLibelleTypeAnnexe(typeAnnexeDetails.getLibelleTypeAnnexe());

		final TypeAnnexe updatedTypeAnnexe = typeAnnexeService.update(typeAnnexe);

		return ResponseEntity.ok(updatedTypeAnnexe);
	}

	@GetMapping("/typeAnnexes/{id}")
	public ResponseEntity<TypeAnnexe> getTypeAnnexeById(
			@PathVariable(value = "id") Long idTypeAnnexe)
			throws ResourceNotFoundException {

		TypeAnnexe typeAnnexe = typeAnnexeService.readOne(idTypeAnnexe)
				.orElseThrow(() -> new ResourceNotFoundException("Le type annexe" + idTypeAnnexe + " n'existe pas "));

		return ResponseEntity.ok().body(typeAnnexe);
	}

	@DeleteMapping("/typeAnnexes/{id}")
	public Map<String, Boolean> deleteTypeAnnexe(@PathVariable(value = "id") Long idTypeAnnexe)
			throws ResourceNotFoundException {

		TypeAnnexe typeAnnexe = typeAnnexeService.readOne(idTypeAnnexe)
				.orElseThrow(() -> new ResourceNotFoundException("Le type annexe" + idTypeAnnexe + " n'existe pas "));

		typeAnnexeService.delete(typeAnnexe);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);

		return response;

	}
	
	@GetMapping("/typeAnnexes")
	public List<TypeAnnexe> getAllTypeAnnexe(){
		return typeAnnexeService.readAll();
	}
	
	@GetMapping("/countTypeAnnexe")
	public Long countAllTypeAnnexe() {
		return typeAnnexeService.count();
	}

}
