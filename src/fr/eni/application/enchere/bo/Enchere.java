package fr.eni.application.enchere.bo;

import java.util.Date;

public class Enchere {
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public int getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	private Date dateEnchere;
	private int montantEnchere;
	public Enchere(Date dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	@Override
	public String toString() {
		return "Date Enchère"+ dateEnchere+ "Montant Enchère"+ montantEnchere;
	}
	
}
