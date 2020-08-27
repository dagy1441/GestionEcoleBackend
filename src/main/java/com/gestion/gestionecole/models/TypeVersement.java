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
public class TypeVersement implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTypeVersement;
	
	private String libelleTypeVersement;
	
	@OneToMany(mappedBy = "typeVersement", fetch = FetchType.LAZY)
	private List<Versement> versements;
	
}
