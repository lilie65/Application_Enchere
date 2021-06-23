package fr.eni.application.enchere.bll;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bo.UtilisateurBO;
import fr.eni.application.enchere.dal.DAOFactory;
import fr.eni.application.enchere.dal.UtilisateursDAO;
import fr.eni.application.enchere.dal.UtilisateursDAOImpl;

public class InscriptionUtilisateurValidator {

	private UtilisateursDAO utilisateurDAO;

	public InscriptionUtilisateurValidator() {
		this.utilisateurDAO = DAOFactory.getUtilisateursDAO();
	}

	public void validerUtilisateurBo(UtilisateurBO utilisateur) throws BusinessException {
		
		BusinessException exception = new BusinessException();

		this.validerPseudo(utilisateur, exception);
		this.validerNom(utilisateur, exception);
		this.validerPrenom(utilisateur, exception);
		this.validerEmail(utilisateur, exception);
		this.validerTelephone(utilisateur, exception);
		this.validerRue(utilisateur, exception);
		this.validerCodePostal(utilisateur, exception);
		this.validerVille(utilisateur, exception);
		this.validerMotDePasse(utilisateur, exception);

		if (!exception.getListeCodesErreur().isEmpty()) {
			throw exception;	
		} 
		this.utilisateurDAO.insert(utilisateur);
	}

	private void validerString(String str, int taille, BusinessException exception, String message) {
		if (str == null || str.equals("") || str.length() > taille) {
			exception.ajouterErreur(message);
		}
	}

	private void validerCodePostal(UtilisateurBO utilisateur, BusinessException exception) {
		if (utilisateur.getCodePostal() == 0) {
			exception.ajouterErreur("Vous devez entrer votre code postal");
		}
	}

	private void validerRue(UtilisateurBO utilisateur, BusinessException exception) {
		validerString(utilisateur.getVille(), 20, exception, "entrez une ville correcte");
	}

	private void validerTelephone(UtilisateurBO utilisateur, BusinessException exception) {
		if (utilisateur.getTelephone() == 0) {
			exception.ajouterErreur("Vous devez entrer votre numéros de téléphone");
		}
	}

	private void validerMotDePasse(UtilisateurBO utilisateur, BusinessException exception) {
		validerString(utilisateur.getMotDePasse(), 20, exception, "entrez un mot de passe correcte");
	}

	private void validerVille(UtilisateurBO utilisateur, BusinessException exception) {
		validerString(utilisateur.getVille(), 20, exception, "Entrez un nom de ville");
	}

	private void validerEmail(UtilisateurBO utilisateur, BusinessException exception) {
		validerString(utilisateur.getEmail(), 50, exception, "entrez un email valide");

	}

	private void validerPrenom(UtilisateurBO utilisateur, BusinessException exception) {
		validerString(utilisateur.getPrenom(), 20, exception, "Entrez votre prénom");
	}

	private void validerNom(UtilisateurBO utilisateur, BusinessException exception) {
		validerString(utilisateur.getNom(), 20, exception, "Nom invalide");
	}

	private void validerPseudo(UtilisateurBO utilisateur, BusinessException exception) {
		validerString(utilisateur.getPseudo(), 20, exception, "Pseudo Invalide");

	}

}
