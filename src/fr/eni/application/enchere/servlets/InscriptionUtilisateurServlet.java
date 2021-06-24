package fr.eni.application.enchere.servlets;

import java.io.IOException;
import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bll.InscriptionUtilisateurValidator;
import fr.eni.application.enchere.bo.UtilisateurBO;
import fr.eni.application.enchere.dal.UtilisateursDAO;
import fr.eni.application.enchere.dal.UtilisateursDAOImpl;

/**
 * Servlet implementation class inscriptionUtilisateur
 */
@WebServlet("/inscriptionUtilisateur")
public class InscriptionUtilisateurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String ATT_SESSION_USER = "sessionUtilisateur";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pseudo;
		String nom;
		String prenom;
		String email;
		int telephone = 0;
		String rue;
		int code_postal = 0;
		String ville;
		String mot_de_passe;
		UtilisateurBO utilisateurBO = null;
		try {
			pseudo = request.getParameter("pseudo");
			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			email = request.getParameter("email");
			
			try {
				code_postal = Integer.parseInt(request.getParameter("code_postal"));
				telephone = Integer.parseInt(request.getParameter("telephone"));
			} catch (NumberFormatException e) {
				request.setAttribute("errors", Arrays.asList("un nombre est nécessaire pour les champs : Téléphone, Code postal"));
				RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp");
				rd.forward(request, response);
				return;
			}
			
			rue = request.getParameter("rue");
			ville = request.getParameter("ville");
			mot_de_passe = request.getParameter("mot_de_passe");
			utilisateurBO = new UtilisateurBO(pseudo, nom, prenom, email, telephone, rue, code_postal,
					ville, mot_de_passe);
			request.setAttribute("utilisateurBO", utilisateurBO);
			InscriptionUtilisateurValidator inscriptionValidator = new InscriptionUtilisateurValidator();
			inscriptionValidator.validerUtilisateurBo(utilisateurBO);
			HttpSession session = request.getSession();
			session.setAttribute(ATT_SESSION_USER, utilisateurBO);
			request.getRequestDispatcher("/WEB-INF/jsp/utilisateurJSP.jsp").forward(request, response);
		} catch (BusinessException e) {
			request.setAttribute("errors", e.getListeCodesErreur());
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp");
			rd.forward(request, response);
			
		}	
		
	}

}
