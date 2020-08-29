package com.gestion.gestionecole.service.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestionecole.models.Classe;
import com.gestion.gestionecole.repository.ClasseRepository;
import com.gestion.gestionecole.service.IClasseService;

@Service
@Transactional
public class ClasseService implements IClasseService{
	
	@Autowired ClasseRepository classeRepository;

	@Override
	public Classe save(Classe entity) {
		return classeRepository.save(entity);
	}

	@Override
	public Classe update(Classe entity) {
		return classeRepository.save(entity);
	}

	@Override
	public void delete(Classe entity) {
		entity.setIdClasse(entity.getIdClasse());
		classeRepository.delete(entity);
	}

	@Override
	public List<Classe> readAll() {
		return classeRepository.findAll();
	}

	@Override
	public Optional<Classe>  readOne(Long id) {
		// TODO Auto-generated method stub
		return classeRepository.findById(id);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return (int) classeRepository.count();
	}

}
