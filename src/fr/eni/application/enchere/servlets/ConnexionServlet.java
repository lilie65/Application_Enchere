package fr.eni.application.enchere.servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bll.InscriptionUtilisateurValidator;
import fr.eni.application.enchere.bo.UtilisateurBO;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_FORM = "form";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	public static final String VUE = "/WEB-INF/jsp/login.jsp";
	private static final String CHAMP_IDENTIFIANT = "identifiant";
	private static final String CHAMP_PASS = "motdepasse";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page de connexion */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Validation du champ mot de passe. */
		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		String identifiant = getValeurChamp(request, CHAMP_IDENTIFIANT);
		/* Préparation de l'objet formulaire */
		InscriptionUtilisateurValidator form = new InscriptionUtilisateurValidator();

		/* Traitement de la requête et récupération du bean en résultant */
		UtilisateurBO utilisateur;
		try {
			utilisateur = form.connecterUtilisateur(motDePasse,identifiant);
			/* Récupération de la session depuis la requête */
			HttpSession session = request.getSession();

			/**
			 * Si aucune erreur de validation n'a eu lieu, alors ajout du bean Utilisateur à
			 * la session, sinon suppression du bean de la session.
			 */
			if (utilisateur!= null) {
				session.setAttribute(ATT_SESSION_USER, utilisateur);
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/utilisateurJSP.jsp").forward(request, response);
			}else {
				// si l'utilisateur est null, cela veut dire qu'il y a une erreur d'autentification
				request.setAttribute("errors", Arrays.asList("nom d'utilisateur ou mot de  passe incorrecte"));
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			}
				
		} catch (BusinessException e) {
			request.setAttribute("errors", e.getListeCodesErreur());
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}

	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}
}
