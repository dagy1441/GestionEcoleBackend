package com.gestion.gestionecole.service.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestionecole.models.TypeAnnexe;
import com.gestion.gestionecole.repository.TypeAnnexeRepository;
import com.gestion.gestionecole.service.ITypeAnnexeService;

@Service
@Transactional
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
	public Optional<TypeAnnexe> readOne(Long id) {
		return typeAnnexeRepository.findById(id);
	}

	@Override
	public Integer count() {
		return (int) typeAnnexeRepository.count();
	}

}
