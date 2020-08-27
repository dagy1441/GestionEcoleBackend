package com.gestion.gestionecole.models;

import java.io.Serializable;
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
public class Classe implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClasse;
	
	private String nomClasse;
	
	@OneToMany(mappedBy = "classe",fetch = FetchType.LAZY)
	private List<AnneeClasse> anneeClasses;
	
	
	public Classe(String nomClasse, List<AnneeClasse> anneeClasses) {
		super();
		this.nomClasse = nomClasse;
		this.anneeClasses = anneeClasses;
	}
	
}
