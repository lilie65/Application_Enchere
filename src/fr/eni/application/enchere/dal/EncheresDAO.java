package fr.eni.application.enchere.dal;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bo.Enchere;

public interface EncheresDAO {

	public void insert (Enchere enchere)throws BusinessException;
		
	
}
