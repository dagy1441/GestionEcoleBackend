package com.gestion.gestionecole.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestion.gestionecole.models.Eleve;
import com.gestion.gestionecole.repository.EleveRepository;
import com.gestion.gestionecole.service.IEleveService;

public class EleveService implements IEleveService{
	
	@Autowired EleveRepository eleveRepository;

	@Override
	public Eleve save(Eleve entity) {
		return eleveRepository.save(entity);
	}

	@Override
	public Eleve update(Eleve entity) {
		return eleveRepository.save(entity);
	}

	@Override
	public void delete(Eleve entity) {
		entity.setIdEleve(entity.getIdEleve());
		eleveRepository.delete(entity);
	}

	@Override
	public List<Eleve> readAll() {
		return eleveRepository.findAll();
	}

	@Override
	public Eleve readOne(Long id) {
		return eleveRepository.getOne(id);
	}

	@Override
	public Integer count() {
		return (int) eleveRepository.count();
	}

}
