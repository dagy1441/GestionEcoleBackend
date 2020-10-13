package com.gestion.gestionecole.service.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestionecole.models.Dossier;
import com.gestion.gestionecole.repository.DossierRepository;
import com.gestion.gestionecole.service.IDossierService;

@Service
@Transactional
public class DossierService implements IDossierService{

	@Autowired DossierRepository dossierRepository;
	
	@Override
	public Dossier save(Dossier entity) {
		return dossierRepository.save(entity);
	}

	@Override
	public Dossier update(Dossier entity) {
		return dossierRepository.save(entity);
	}

	@Override
	public void delete(Dossier entity) {
		entity.setIdDossier(entity.getIdDossier());
		dossierRepository.delete(entity);
	}

	@Override
	public List<Dossier> readAll() {
		return dossierRepository.findAll();
	}

	@Override
	public Optional<Dossier> readOne(Long id) {
		return dossierRepository.findById(id);
	}

	@Override
	public Long count() {
		return (long) dossierRepository.count();
	}

}
