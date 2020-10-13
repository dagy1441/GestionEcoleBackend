package com.gestion.gestionecole.service.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestionecole.models.Inscription;
import com.gestion.gestionecole.repository.InscriptionRepository;
import com.gestion.gestionecole.service.IInscriptionService;

@Service
@Transactional
public class InscriptionService implements IInscriptionService{
	
	@Autowired InscriptionRepository inscriptionRepository;

	@Override
	public Inscription save(Inscription entity) {
		return inscriptionRepository.save(entity);
	}

	@Override
	public Inscription update(Inscription entity) {
		return inscriptionRepository.save(entity);
	}

	@Override
	public void delete(Inscription entity) {
		entity.setCodeInscription(entity.getCodeInscription());		
		inscriptionRepository.delete(entity);
	}

	@Override
	public List<Inscription> readAll() {
		return inscriptionRepository.findAll();
	}

	@Override
	public Optional<Inscription> readOne(Long id) {
		return inscriptionRepository.findById(id);
	}

	@Override
	public Long count() {
		return (long) inscriptionRepository.count();
	}

}
