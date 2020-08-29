package com.gestion.gestionecole.service.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestionecole.models.AnneeScolaire;
import com.gestion.gestionecole.repository.AnneeScolaireRepository;
import com.gestion.gestionecole.service.IAnneeScolaireService;

@Service
@Transactional
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
	public Optional<AnneeScolaire> readOne(Long id) {
		return anneeScolaireRepository.findById(id);
	}

	@Override
	public Integer count() {
		return (int) anneeScolaireRepository.count();
	}

}
