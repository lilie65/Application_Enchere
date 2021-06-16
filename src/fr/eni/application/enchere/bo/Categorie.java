package fr.eni.application.enchere.bo;

public class Categorie {
	private String noCategorie;
	
	private String libelle;

	public Categorie(String noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	public String getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(String noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public String toString() {
		return "noCategorie"+noCategorie+"libelle"+noCategorie;
	}
}