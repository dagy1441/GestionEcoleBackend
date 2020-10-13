package com.gestion.gestionecole.service.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestionecole.models.Annexe;
import com.gestion.gestionecole.repository.AnnexeRepository;
import com.gestion.gestionecole.service.IAnnexeService;

@Service
@Transactional
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
	public Optional<Annexe> readOne(Long id) {
		return annexeRepository.findById(id);
	}

	@Override
	public Long count() {
		return (long) annexeRepository.count();
	}

}
