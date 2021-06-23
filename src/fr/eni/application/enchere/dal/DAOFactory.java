package fr.eni.application.enchere.dal;

public abstract class DAOFactory {
	public static UtilisateursDAO getUtilisateursDAO()
	{
		return new UtilisateursDAOImpl();
	}

}
