package com.gestion.gestionecole.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestion.gestionecole.models.TypeVersement;
import com.gestion.gestionecole.repository.TypeVersementRepository;
import com.gestion.gestionecole.service.ITypeVersementService;

public class TypeVersementService implements ITypeVersementService{
	
	@Autowired TypeVersementRepository typeVersementRepository;

	@Override
	public TypeVersement save(TypeVersement entity) {
		return typeVersementRepository.save(entity);
	}

	@Override
	public TypeVersement update(TypeVersement entity) {
		return typeVersementRepository.save(entity);
	}

	@Override
	public void delete(TypeVersement entity) {
		entity.setIdTypeVersement(entity.getIdTypeVersement());
		typeVersementRepository.delete(entity);
	}

	@Override
	public List<TypeVersement> readAll() {
		return typeVersementRepository.findAll();
	}

	@Override
	public TypeVersement readOne(Long id) {
		return typeVersementRepository.getOne(id);
	}

	@Override
	public Integer count() {
		return (int) typeVersementRepository.count();
	}

}
