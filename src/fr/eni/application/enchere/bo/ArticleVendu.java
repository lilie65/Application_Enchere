package fr.eni.application.enchere.bo;

import java.time.LocalDate;

public class ArticleVendu {
	
	private String noArticle;
	
	private String description;
	
	private LocalDate dateDebutEncheres;
	
	private LocalDate dateFinEncheres;
	
	private String miseAPrix;
	
	private String prixVente;
	
	private String etatVente;


	public ArticleVendu(String noArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			String miseAPrix, String prixVente, String etatVente) {
		super();
		this.noArticle = noArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		
	}

	public String getNoArticle() {
		return noArticle;
	}


	public void setNoArticle(String noArticle) {
		this.noArticle = noArticle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}


	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}


	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}


	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}


	public String getMiseAPrix() {
		return miseAPrix;
	}


	public void setMiseAPrix(String miseAPrix) {
		this.miseAPrix = miseAPrix;
	}


	public String getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(String prixVente) {
		this.prixVente = prixVente;
	}


	public String getEtatVente() {
		return etatVente;
	}


	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}


	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", description=" + description + ", miseAPrix=" + miseAPrix
				+ ", prixVente=" + prixVente + ", etatVente=" + etatVente + "]";
	}
	

}
