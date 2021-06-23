package fr.eni.application.enchere.bll;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bo.UtilisateurBO;
import fr.eni.application.enchere.dal.UtilisateursDAO;
import fr.eni.application.enchere.dal.UtilisateursDAOImpl;

public class ConnexionUtilisateur {

	private String resultat;

	public String getResultat() {
		return resultat;
	}

	public UtilisateurBO connecterUtilisateur(String motDePasse, String identifiant) throws BusinessException {
		UtilisateurBO utilisateurIHM = new UtilisateurBO();
		/* Validation du champ identifiant. */
		validationIdentifiant(identifiant);

		if (identifiant.contains("@")) {
			validationEmail(identifiant);

			utilisateurIHM.setEmail(identifiant);
		} else {

			utilisateurIHM.setPseudo(identifiant);
		}

		validationMotDePasse(motDePasse);
		utilisateurIHM.setMotDePasse(motDePasse);

		/* Initialisation du résultat global de la validation. */
		UtilisateursDAO utilisateurDAO = new UtilisateursDAOImpl();
		UtilisateurBO UtilisateurPseudoEmailEnBDD = null;

		String pseudoEmail = null;
		if (utilisateurIHM.getEmail() != null) {
			pseudoEmail = utilisateurIHM.getEmail();
		} else if (utilisateurIHM.getPseudo() != null) {
			pseudoEmail = utilisateurIHM.getPseudo();
		}

		UtilisateurPseudoEmailEnBDD = utilisateurDAO.verifConnection(pseudoEmail, motDePasse);

		return UtilisateurPseudoEmailEnBDD;
	}

	private void validationIdentifiant(String identifiant) throws BusinessException {
		if (identifiant == null || identifiant.trim().isEmpty()) {
			throw new BusinessException("identifiant non valide");
		}

	}

	/**
	 * Valide l'adresse email saisie.
	 */
	private void validationEmail(String email) throws BusinessException {
		if (email != null && !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			throw new BusinessException("Merci de saisir une adresse mail valide.");
		}
	}

	/**
	 * Valide le mot de passe saisi.
	 */
	private void validationMotDePasse(String motDePasse) throws BusinessException {
		if (motDePasse != null) {
			if (motDePasse.length() < 3 || motDePasse.length() > 15) {
				throw new BusinessException("Le mot de passe doit contenir au moins 3 caractères.");
			}
		} else {
			throw new BusinessException("Merci de saisir votre mot de passe.");
		}
	}

}
