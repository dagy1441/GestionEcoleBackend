package com.gestion.gestionecole.service.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestionecole.models.Eleve;
import com.gestion.gestionecole.repository.EleveRepository;
import com.gestion.gestionecole.service.IEleveService;

@Service
@Transactional
public class EleveService implements IEleveService{
	
	@Autowired EleveRepository eleveRepository;

	@Override
	public Eleve save(Eleve entity) {
		return eleveRepository.save(entity);
	}

	@Override
	public Eleve update(Eleve entity) {
		return eleveRepository.save(entity);
	}

	@Override
	public void delete(Eleve entity) {
		entity.setIdEleve(entity.getIdEleve());
		eleveRepository.delete(entity);
	}

	@Override
	public List<Eleve> readAll() {
		return eleveRepository.findAll();
	}

	@Override
	public Optional<Eleve> readOne(Long id) {
		return eleveRepository.findById(id);
	}

	@Override
	public Long count() {
		return (long) eleveRepository.count();
	}

	@Override
	public Optional<Eleve> findByMatricule(String matricule) {
		return  eleveRepository.findByMatricule(matricule);
	}

	@Override
	public List<Eleve> findByNom(String nom) {
		return eleveRepository.findByNom(nom);
	}

	@Override
	public List<Eleve> findByPrenom(String prenom) {
		return eleveRepository.findByPrenom(prenom);
	}

	@Override
	public List<Eleve> findByNomLikeOrPrenomLike(String nom, String prenom) {
		return eleveRepository.findByNomLikeOrPrenomLike(nom, prenom);
	}

	



}
