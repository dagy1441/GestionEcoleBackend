package com.gestion.gestionecole.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class AnneeScolaire implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnneeScolaire;
	
	private Date dateDebut;
	
	private Date dateFin;
	
	private String libelle;
	
	@OneToMany(mappedBy = "anneeScolaire",fetch = FetchType.LAZY)
	private List<AnneeClasse> anneeClasses;

	public AnneeScolaire(Date dateDebut, Date dateFin, String libelle, List<AnneeClasse> anneeClasses) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.libelle = libelle;
		this.anneeClasses = anneeClasses;
	}
	
	

}
