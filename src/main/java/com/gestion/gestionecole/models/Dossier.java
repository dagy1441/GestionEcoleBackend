package com.gestion.gestionecole.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Dossier implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDossier;
	
	private int etat;
	
	@ManyToOne 
//	@JoinColumn(name="type_dossier_id", referencedColumnName = "idTypeDossier")
	@JsonIgnore
	private TypeDossier typeDossier;
	
	@ManyToOne 
//	@JoinColumn(name="inscription_id", referencedColumnName = "idInscription")
	@JsonIgnore
	private Inscription inscription;

}
