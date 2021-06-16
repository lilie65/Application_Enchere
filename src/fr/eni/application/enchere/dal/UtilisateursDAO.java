package fr.eni.application.enchere.dal;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bo.Utilisateur;

public interface UtilisateursDAO {
	public void insert(Utilisateur utilisateurs) throws BusinessException;
}
