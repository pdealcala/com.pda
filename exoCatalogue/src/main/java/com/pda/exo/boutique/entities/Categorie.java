package com.pda.exo.boutique.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categorie {

	@Id @GeneratedValue
	private Long id;
	private String libelle;

	public Categorie() {
		super();
	}
	
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
