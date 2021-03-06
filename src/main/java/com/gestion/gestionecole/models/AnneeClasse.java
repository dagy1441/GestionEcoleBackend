package com.gestion.gestionecole.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class AnneeClasse implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnneeClasse;
	
	private int montant;
	
	@ManyToOne 
//	@JoinColumn(name="classe_id", referencedColumnName = "idClasse")
	@JsonIgnore
	private Classe classe;
	
	@ManyToOne 
//	@JoinColumn(name="annee_scolaire_id", referencedColumnName = "idAnneeScolaire")
	@JsonIgnore
	private AnneeScolaire anneeScolaire;
	
	@OneToMany(mappedBy = "anneeClasse", fetch = FetchType.LAZY)
	private List<Inscription> inscriptions;
	
	public AnneeClasse(int montant, Classe classe, AnneeScolaire anneeScolaire) {
		super();
		this.montant = montant;
		this.classe = classe;
		this.anneeScolaire = anneeScolaire;
	}
	
	
	
}
