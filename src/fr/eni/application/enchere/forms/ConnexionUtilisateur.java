package fr.eni.application.enchere.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bo.UtilisateurBO;
import fr.eni.application.enchere.dal.UtilisateursDAO;
import fr.eni.application.enchere.dal.UtilisateursDAOImpl;

public class ConnexionUtilisateur {
	private static final String CHAMP_IDENTIFIANT = "identifiant";
	private static final String CHAMP_PASS = "motdepasse";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public UtilisateurBO connecterUtilisateur(HttpServletRequest request) {
		UtilisateurBO utilisateurIHM = new UtilisateurBO();
		String identifiant = getValeurChamp(request, CHAMP_IDENTIFIANT);

		try {
			if (identifiant.contains("@")) {
				validationEmail(identifiant);

				utilisateurIHM.setEmail(identifiant);
			} else {
				validationPseudo(identifiant);

				utilisateurIHM.setPseudo(identifiant);
			}
		} catch (Exception e) {
			setErreur(CHAMP_IDENTIFIANT, e.getMessage());
		}
		String motDePasse = getValeurChamp(request, CHAMP_PASS);

		/* Validation du champ mot de passe. */
		try {
			validationMotDePasse(motDePasse);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
		}
		utilisateurIHM.setMotDePasse(motDePasse);

		/* Initialisation du résultat global de la validation. */
		UtilisateursDAO utilisateurDAO = new UtilisateursDAOImpl();
		UtilisateurBO UtilisateurEnBDD = null;
		try {
			UtilisateurEnBDD = utilisateurDAO.selectByPseudo(utilisateurIHM.getPseudo());
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (erreurs.isEmpty()) {
			resultat = "Succès de la connexion.";
		} else {
			resultat = "Échec de la connexion.";
		}

		return UtilisateurEnBDD;
	}

	/**
	 * Valide l'adresse email saisie.
	 */
	private void validationPseudo(String pseudo) throws Exception {
		if (pseudo == null || pseudo.trim().isEmpty()) {
			throw new Exception("Merci de saisir un  pseudo valide.");
		}
	}

	/**
	 * Valide l'adresse email saisie.
	 */
	private void validationEmail(String email) throws Exception {
		if (email != null && !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			throw new Exception("Merci de saisir une adresse mail valide.");
		}
	}

	/**
	 * Valide le mot de passe saisi.
	 */
	private void validationMotDePasse(String motDePasse) throws Exception {
		if (motDePasse != null) {
			if (motDePasse.length() < 3) {
				throw new Exception("Le mot de passe doit contenir au moins 3 caractères.");
			}
		} else {
			throw new Exception("Merci de saisir votre mot de passe.");
		}
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}
}
