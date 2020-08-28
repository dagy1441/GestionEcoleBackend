package com.gestion.gestionecole.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestion.gestionecole.models.Versement;
import com.gestion.gestionecole.repository.VersementRepository;
import com.gestion.gestionecole.service.IVersementService;

public class VersementService implements IVersementService{
	
	@Autowired VersementRepository versementRepository;

	@Override
	public Versement save(Versement entity) {
		return versementRepository.save(entity);
	}

	@Override
	public Versement update(Versement entity) {
		return versementRepository.save(entity);
	}

	@Override
	public void delete(Versement entity) {
		entity.setIdVersement(entity.getIdVersement());
		versementRepository.delete(entity);
	}

	@Override
	public List<Versement> readAll() {
		return versementRepository.findAll();
	}

	@Override
	public Versement readOne(Long id) {
		return versementRepository.getOne(id);
	}

	@Override
	public Integer count() {
		return (int) versementRepository.count();
	}

}
