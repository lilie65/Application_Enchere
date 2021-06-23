package fr.eni.application.enchere;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;
	private List<String> listeCodesErreur;

	public BusinessException() {
		super();
		this.listeCodesErreur = new ArrayList<>();
	}

	public BusinessException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param code Code de l'erreur. Doit avoir un message associé dans un fichier
	 *             properties.
	 */
	public void ajouterErreur(String message) {
		listeCodesErreur.add(message);
	}

	public boolean hasErreurs() {
		return this.listeCodesErreur.size() > 0;
	}

	public List<String> getListeCodesErreur() {
		return this.listeCodesErreur;
	}

}
