package com.gestion.gestionecole.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestion.gestionecole.models.TypeAnnexe;
import com.gestion.gestionecole.repository.TypeAnnexeRepository;
import com.gestion.gestionecole.service.ITypeAnnexeService;

public class TypeAnnexeService implements ITypeAnnexeService{
	
	@Autowired TypeAnnexeRepository typeAnnexeRepository;

	@Override
	public TypeAnnexe save(TypeAnnexe entity) {
		return typeAnnexeRepository.save(entity);
	}

	@Override
	public TypeAnnexe update(TypeAnnexe entity) {
		return typeAnnexeRepository.save(entity);
	}

	@Override
	public void delete(TypeAnnexe entity) {
		entity.setIdAnnexe(entity.getIdAnnexe());
		typeAnnexeRepository.delete(entity);
	}

	@Override
	public List<TypeAnnexe> readAll() {
		return typeAnnexeRepository.findAll();
	}

	@Override
	public TypeAnnexe readOne(Long id) {
		return typeAnnexeRepository.getOne(id);
	}

	@Override
	public Integer count() {
		return (int) typeAnnexeRepository.count();
	}

}
