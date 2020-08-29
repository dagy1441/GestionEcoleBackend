package com.gestion.gestionecole.service.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestionecole.models.TypeDossier;
import com.gestion.gestionecole.repository.TypeDossierRepository;
import com.gestion.gestionecole.service.ITypeDossierService;

@Service
@Transactional
public class TypeDossierService implements ITypeDossierService{
	
	@Autowired TypeDossierRepository typeDossierRepository;

	@Override
	public TypeDossier save(TypeDossier entity) {
		return typeDossierRepository.save(entity);
	}

	@Override
	public TypeDossier update(TypeDossier entity) {
		return typeDossierRepository.save(entity);
	}

	@Override
	public void delete(TypeDossier entity) {
		entity.setIdTypeDossier(entity.getIdTypeDossier());
		typeDossierRepository.delete(entity);
	}

	@Override
	public List<TypeDossier> readAll() {
		return typeDossierRepository.findAll();
	}

	@Override
	public Optional<TypeDossier> readOne(Long id) {
		return typeDossierRepository.findById(id);
	}

	@Override
	public Integer count() {
		return (int) typeDossierRepository.count();
	}

}
