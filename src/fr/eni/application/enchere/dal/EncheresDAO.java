package fr.eni.application.enchere.dal;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bo.Enchere;
import fr.eni.application.enchere.bo.UtilisateurBO;

public interface EncheresDAO {

	public int insert (Enchere enchere)throws BusinessException;
		
	public UtilisateurBO getUtilisateurs(int noUtilisateur);

	
}
