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
public class Versement implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVersement;
	
	private int montant;
	
	private Date dateVersement;
	
	private Date dateEchean;
	
	private String moisRegler;
	
	@ManyToOne 
	private TypeVersement typeVersement;
	
	@ManyToOne 
	private Inscription inscription;
}
