package com.gestion.gestionecole.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Eleve implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEleve;
	
	private String matricule;
	
	private String nom;
	
	private String prenom;
	
	private String sexe;
	
	private Date dateDeNaissance;
	
	private String lieuDeNaissance;
	
	@ManyToOne 
	private Inscription inscription;

}
