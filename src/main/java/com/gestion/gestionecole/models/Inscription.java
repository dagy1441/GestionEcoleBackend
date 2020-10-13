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
public class Inscription implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInscription;
	
	private String codeInscription;
	
	private Long idAnneeInscription;
	
	private int ficheInscriptionEnLigne;
	
	private int ficheInscriptionEnPresence;
	
	private int ficheAttestationBEPC;
	
	private int ficheAttestationBT;
	
	private int ficheAttestationCAP;
	
	private int dernierBulletin;
	
	@ManyToOne
//	@JoinColumn(name="annee_classe_id", referencedColumnName = "idAnneeClasse")
	@JsonIgnore
	private AnneeClasse anneeClasse;
	
	@ManyToOne 
//	@JoinColumn(name="eleve_id", referencedColumnName = "idEleve")
	@JsonIgnore
	private Eleve eleve;
	
	@OneToMany(mappedBy = "inscription", fetch = FetchType.LAZY)
	private List<Versement> versements;
	
	
	@OneToMany(mappedBy = "inscription", fetch = FetchType.LAZY)
	private List<Dossier> dossiers;
	
	@OneToMany(mappedBy = "inscription", fetch = FetchType.LAZY)
	private List<Annexe> annexes;
	
}
