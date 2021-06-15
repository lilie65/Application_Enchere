package fr.eni.application.enchere;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletTestPoolConnexion
 */
@WebServlet("/ServletTestPoolConnexion")
public class ServletTestPoolConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Context context = new InitialContext();
			//recherche de la datasource
			DataSource dataSource= (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
			//demande une connexion. la méthode getConnection met la demande en attente 
			//tant qu'il n'y a pas de connexion disponible dans le pool
			Connection cnx = dataSource.getConnection();
			out.print("la connexion est :"+(cnx.isClosed()?"fermée":"ouverte")+".") ;
			//libéré la connexion lorsque l'on en a plus besoin:
			cnx.close();//la connexion n'est pas fermé mais remise dans le pool.
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("une erreur est survenue lors de l'utilisation de la base de données"+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
