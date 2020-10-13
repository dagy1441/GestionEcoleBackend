package com.gestion.gestionecole.service.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestionecole.models.Versement;
import com.gestion.gestionecole.repository.VersementRepository;
import com.gestion.gestionecole.service.IVersementService;

@Service
@Transactional
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
	public Optional<Versement> readOne(Long id) {
		return versementRepository.findById(id);
	}

	@Override
	public Long count() {
		return (long) versementRepository.count();
	}

}
