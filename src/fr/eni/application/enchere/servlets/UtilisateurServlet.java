package fr.eni.application.enchere.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bo.UtilisateurBO;
import fr.eni.application.enchere.dal.UtilisateursDAO;
import fr.eni.application.enchere.dal.UtilisateursDAOImpl;

/**
 * Servlet implementation class Utilisateur
 */
@WebServlet("/Utilisateur")
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateursDAO utilisateurDAO = new UtilisateursDAOImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		UtilisateurBO utilisateur = null;
		try {

			utilisateur = utilisateurDAO.select(1);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("utilisateur", utilisateur);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/utilisateurJSP.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}