package com.gestion.gestionecole.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestion.gestionecole.models.AnneeScolaire;
import com.gestion.gestionecole.repository.AnneeScolaireRepository;
import com.gestion.gestionecole.service.IAnneeScolaireService;

public class AnneeScolaireService implements IAnneeScolaireService{
	
	@Autowired AnneeScolaireRepository anneeScolaireRepository;

	@Override
	public AnneeScolaire save(AnneeScolaire entity) {
		return anneeScolaireRepository.save(entity);
	}

	@Override
	public AnneeScolaire update(AnneeScolaire entity) {
		return anneeScolaireRepository.save(entity);
	}

	@Override
	public void delete(AnneeScolaire entity) {
		entity.setIdAnneeScolaire(entity.getIdAnneeScolaire());
		anneeScolaireRepository.delete(entity);
	}

	@Override
	public List<AnneeScolaire> readAll() {
		return anneeScolaireRepository.findAll();
	}

	@Override
	public AnneeScolaire readOne(Long id) {
		return anneeScolaireRepository.getOne(id);
	}

	@Override
	public Integer count() {
		return (int) anneeScolaireRepository.count();
	}

}
