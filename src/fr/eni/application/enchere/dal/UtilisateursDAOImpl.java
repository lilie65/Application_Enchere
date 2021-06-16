package fr.eni.application.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bll.CodesResultat;
import fr.eni.application.enchere.bo.Utilisateur;

public class UtilisateursDAOImpl  implements UtilisateursDAO{
	private static final String INSERT = "INSERT INTO AVIS(description, note) VALUES(?,?);";

	@Override
	public void insert (Utilisateur utilisateurs)throws BusinessException {
		if (utilisateurs == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultat.INSERT_OBJET_NULL);
			throw new BusinessException();
		}

		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,utilisateurs.getPseudo());
			pstmt.setString(2, utilisateurs.getNom());
			pstmt.setString(3, utilisateurs.getPrenom());
			pstmt.setString(4, utilisateurs.getEmail());
			pstmt.setInt(5, utilisateurs.getTelephone());
			pstmt.setString(6, utilisateurs.getRue());
			pstmt.setInt(7, utilisateurs.getCodePostal());
			pstmt.setString(8, utilisateurs.getVille());
			pstmt.setString(9, utilisateurs.getMotDePasse());
			pstmt.setInt(10, utilisateurs.getCredit());
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				utilisateurs.setNoUtilisateur(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("CK_AVIS_note")) {
				businessException.ajouterErreur(CodesResultat.INSERT_AVIS_NOTE_ECHEC);
			} else {
				businessException.ajouterErreur(CodesResultat.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}
	}

}
