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
import com.gestion.gestionecole.models.Classe;
import com.gestion.gestionecole.service.implement.ClasseService;

@RestController
@RequestMapping("/api/v1")
public class ClasseController {

	@Autowired
	ClasseService classeService;

	@PostMapping("/classes")
	public Classe createClasse(@Valid @RequestBody Classe classe) {
		return classeService.save(classe);
	}

	@PutMapping("/classes/{id}")
	public ResponseEntity<Classe> updateClasse(@PathVariable(value = "id") Long idClasse,
			@Valid @RequestBody Classe classeDetails) throws ResourceNotFoundException {

		Classe classe = classeService.readOne(idClasse)
				.orElseThrow(() -> new ResourceNotFoundException("La classe " + idClasse + " n'existe pas "));

		classe.setNomClasse(classeDetails.getNomClasse());

		final Classe updatedClasse = classeService.update(classe);

		return ResponseEntity.ok(updatedClasse);

	}

	@GetMapping("/classes")
	public List<Classe> getAllClasses() {
		return classeService.readAll();
	}

	@GetMapping("/classes/{id}")
	public ResponseEntity<Classe> getClasseById(
			@PathVariable(value = "id") Long idClasse)
			throws ResourceNotFoundException {

		Classe classe = classeService.readOne(idClasse)
				.orElseThrow(() -> new ResourceNotFoundException("La classe " + idClasse + " n'existe pas "));

		return ResponseEntity.ok().body(classe);

	}

	@DeleteMapping("/classe/{id}")
	public Map<String, Boolean> deleteClasse(@PathVariable(value = "id") Long idClasse)
			throws ResourceNotFoundException {

		Classe classe = classeService.readOne(idClasse)
				.orElseThrow(() -> new ResourceNotFoundException("La classe " + idClasse + " n'existe pas "));
		
		classeService.delete(classe);
		
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;

	}

	@GetMapping("/countClasses")
	public Long countClasse() {
		return classeService.count();
	}

}
