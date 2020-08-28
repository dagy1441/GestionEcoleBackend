package com.gestion.gestionecole.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestion.gestionecole.models.AnneeClasse;
import com.gestion.gestionecole.repository.AnneeClasseRepository;
import com.gestion.gestionecole.service.IAnneeClasseService;

public class AnneeClasseService implements IAnneeClasseService{
	
	@Autowired AnneeClasseRepository anneeClasseRepository;

	@Override
	public AnneeClasse save(AnneeClasse entity) {
		return anneeClasseRepository.save(entity);
	}

	@Override
	public AnneeClasse update(AnneeClasse entity) {
		return anneeClasseRepository.save(entity);
	}

	@Override
	public void delete(AnneeClasse entity) {
		entity.setIdAnneeClasse(entity.getIdAnneeClasse());
		anneeClasseRepository.delete(entity);
	}

	@Override
	public List<AnneeClasse> readAll() {
		return anneeClasseRepository.findAll();
	}

	@Override
	public AnneeClasse readOne(Long id) {
		return anneeClasseRepository.getOne(id);
	}

	@Override
	public Integer count() {
		return (int) anneeClasseRepository.count();
	}

}
