package com.gestion.gestionecole.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestion.gestionecole.models.Annexe;
import com.gestion.gestionecole.repository.AnnexeRepository;
import com.gestion.gestionecole.service.IAnnexeService;

public class AnnexeService implements IAnnexeService{
	
	@Autowired AnnexeRepository annexeRepository;

	@Override
	public Annexe save(Annexe entity) {
		return annexeRepository.save(entity);
	}

	@Override
	public Annexe update(Annexe entity) {
		return annexeRepository.save(entity);
	}

	@Override
	public void delete(Annexe entity) {
		entity.setIdAnnexe(entity.getIdAnnexe());
		annexeRepository.delete(entity);
	}

	@Override
	public List<Annexe> readAll() {
		return annexeRepository.findAll();
	}

	@Override
	public Annexe readOne(Long id) {
		return annexeRepository.getOne(id);
	}

	@Override
	public Integer count() {
		return (int) annexeRepository.count();
	}

}
