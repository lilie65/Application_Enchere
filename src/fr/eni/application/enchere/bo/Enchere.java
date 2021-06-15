package fr.eni.application.enchere.bo;

import java.time.LocalDateTime;
import java.util.Date;

public class Enchere {
	private int identifiantEnchere;
	
	private LocalDateTime dateEnchere;
	
	private int montantEnchere;

	public Enchere(LocalDateTime dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	public int getIdentifiantEnchere() {
		return identifiantEnchere;
	}

	public void setIdentifiantEnchere(int identifiantEnchere) {
		this.identifiantEnchere = identifiantEnchere;
	}


	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		return "identifiantEnchere"+identifiantEnchere + "Date Enchère" + dateEnchere + "Montant Enchère" + montantEnchere;
	}

}
