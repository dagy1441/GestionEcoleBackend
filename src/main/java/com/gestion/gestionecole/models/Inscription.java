package com.gestion.gestionecole.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Inscription implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeInscription;
	
	private Long idAnneeClasseInscription;
	
	private String ficheInscriptionEnLigne;
	
	private String ficheInscriptionEnPresence;
	
	private String ficheAttestationBEPC;
	
	private String ficheAttestationBT;
	
	private String ficheAttestationCAP;
	
	private String dernierBulletin;
	
	@ManyToOne 
	private AnneeClasse anneeClasse;
	
	@ManyToOne 
	private Eleve eleve;
	
	@OneToMany(mappedBy = "inscription", fetch = FetchType.LAZY)
	private List<Versement> versements;
	
	@OneToMany(mappedBy = "inscription", fetch = FetchType.LAZY)
	private List<Eleve> eleves ;
	
	@OneToMany(mappedBy = "inscription", fetch = FetchType.LAZY)
	private List<Dossier> dossiers;
	
	@OneToMany(mappedBy = "inscription", fetch = FetchType.LAZY)
	private List<Annexe> annexes;
	
}
