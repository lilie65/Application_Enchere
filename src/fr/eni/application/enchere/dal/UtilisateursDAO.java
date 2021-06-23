package fr.eni.application.enchere.dal;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bo.UtilisateurBO;

public interface UtilisateursDAO {
	public void insert(UtilisateurBO utilisateurs) throws BusinessException;
	public UtilisateurBO select(int idUtilisateur)throws BusinessException;
	UtilisateurBO verifConnection(String pseudoEmail, String mdp) throws BusinessException;
	
}
