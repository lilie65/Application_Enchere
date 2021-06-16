package fr.eni.application.enchere.dal;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bo.Utilisateurs;

public interface UtilisateursDAO {
	public void insert(Utilisateurs utilisateurs) throws BusinessException;
}
