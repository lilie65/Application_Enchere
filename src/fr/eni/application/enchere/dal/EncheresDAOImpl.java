package fr.eni.application.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bll.CodesResultat;
import fr.eni.application.enchere.bo.Enchere;
import fr.eni.application.enchere.bo.Utilisateurs;

public class EncheresDAOImpl implements EncheresDAO {
	private static final String INSERT = "INSERT INTO AVIS(description, note) VALUES(?,?);";

	@Override
	public void insert(Enchere enchere) throws BusinessException {
		if (enchere == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultat.INSERT_OBJET_NULL);
			throw new BusinessException();
		}

		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setTimestamp(1, Timestamp.valueOf(enchere.getDateEnchere()));
			pstmt.setInt(2, enchere.getMontantEnchere());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				enchere.setIdentifiantEnchere(rs.getInt(1));
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

	@Override
	public Utilisateurs getUtilisateurs(int noUtilisateur) {
	
		return null;
	}

}
