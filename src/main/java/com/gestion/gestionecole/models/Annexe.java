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
public class Annexe implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnnexe;
	
	private int etat;
	
	@ManyToOne
//	@JoinColumn(name="type_annexe_id", referencedColumnName = "idTypeAnnexe")
	@JsonIgnore
	private TypeAnnexe typeAnnexe;
	
	@ManyToOne
//	@JoinColumn(name = "id_inscription", referencedColumnName = "idInscription")
	@JsonIgnore
	private Inscription inscription;

}
