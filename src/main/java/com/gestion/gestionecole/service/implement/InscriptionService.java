package com.gestion.gestionecole.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestion.gestionecole.models.Inscription;
import com.gestion.gestionecole.repository.InscriptionRepository;
import com.gestion.gestionecole.service.IInscriptionService;

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
	public Inscription readOne(Long id) {
		return inscriptionRepository.getOne(id);
	}

	@Override
	public Integer count() {
		return (int) inscriptionRepository.count();
	}

}
