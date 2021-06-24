package fr.eni.application.enchere.bll;

import java.text.StringCharacterIterator;

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
		if (utilisateur.getCodePostal() > 100000) {
			exception.ajouterErreur("Vous devez entrer votre code postal");
		}
	}

	private void validerRue(UtilisateurBO utilisateur, BusinessException exception) {
		validerString(utilisateur.getRue(), 20, exception, "entrez un nom de rue correcte");
	}

	private void validerTelephone(UtilisateurBO utilisateur, BusinessException exception) {
		if (utilisateur.getTelephone() > 1000000000) {
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

	public UtilisateurBO connecterUtilisateur(String motDePasse, String identifiant) throws BusinessException {
		BusinessException exception = new BusinessException();
		UtilisateurBO utilisateurIHM = new UtilisateurBO();

		/* Validation du champ identifiant. */
		validationIdentifiant(identifiant, exception);
		validationMotDePasse(motDePasse, exception);
		
		if(!exception.getListeCodesErreur().isEmpty()) {
			throw exception;
		}
		
		if (identifiant.contains("@")) {
			
			validationEmail(identifiant, exception);
			
			if(!exception.getListeCodesErreur().isEmpty()) {
				throw exception;
			}

			utilisateurIHM.setEmail(identifiant);
		} else {

			utilisateurIHM.setPseudo(identifiant);
		}

		utilisateurIHM.setMotDePasse(motDePasse);

		/* Initialisation du résultat global de la validation. */
		utilisateurDAO = new UtilisateursDAOImpl();
		UtilisateurBO UtilisateurPseudoEmailEnBDD = null;

		String pseudoEmail = null;
		if (utilisateurIHM.getEmail() != null) {
			pseudoEmail = utilisateurIHM.getEmail();
		} else if (utilisateurIHM.getPseudo() != null) {
			pseudoEmail = utilisateurIHM.getPseudo();
		}
		if (exception.getListeCodesErreur().isEmpty()) {
			UtilisateurPseudoEmailEnBDD = utilisateurDAO.verifConnection(pseudoEmail, motDePasse);
			return UtilisateurPseudoEmailEnBDD;
		}
		throw exception;

	}

	private void validationIdentifiant(String identifiant, BusinessException exception) throws BusinessException {
		if (identifiant == null || identifiant.trim().isEmpty()) {
			exception.ajouterErreur("identifiant non valide");
		}

	}

	/**
	 * Valide l'adresse email saisie.
	 */
	private void validationEmail(String email, BusinessException exception) throws BusinessException {
		if (email != null && !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			exception.ajouterErreur("Merci de saisir une adresse mail valide.");
		}
	}

	/**
	 * Valide le mot de passe saisi.
	 */
	private void validationMotDePasse(String motDePasse, BusinessException exception) throws BusinessException {
		if (motDePasse == null || !(motDePasse.length() > 3 && motDePasse.length() < 15)) {
			exception.ajouterErreur("Le mot de passe doit contenir entre 3 et 15 caractères");	
		}
	}

}
