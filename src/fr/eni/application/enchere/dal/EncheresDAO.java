package fr.eni.application.enchere.dal;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bo.Enchere;
import fr.eni.application.enchere.bo.Utilisateurs;

public interface EncheresDAO {

	public void insert (Enchere enchere)throws BusinessException;
		
	public Utilisateurs getUtilisateurs(int noUtilisateur);

	void insert(Utilisateurs utilisateurs) throws BusinessException;
}
