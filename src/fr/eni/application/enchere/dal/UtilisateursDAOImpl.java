package fr.eni.application.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bll.CodesResultat;
import fr.eni.application.enchere.bo.UtilisateurBO;

public class UtilisateursDAOImpl implements UtilisateursDAO {
	private static final String INSERT = "INSERT INTO utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?, ?,?,?,?,?,?,?,?);";
	private static final String SELECT = "select no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur from utilisateurs where no_utilisateur= ";

	@Override
	public UtilisateurBO select(int idUtilisateur) throws BusinessException {
		if (idUtilisateur < 1) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultat.INSERT_OBJET_NULL);
			throw new BusinessException();
		}
		UtilisateurBO utilisateur = new UtilisateurBO();
		try (Connection cnx = ConnectionProvider.getConnection()) {

			java.sql.Statement pstmt = cnx.createStatement();
			ResultSet rs = pstmt.executeQuery(SELECT + idUtilisateur);

			if (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getInt("telephone"));
				utilisateur.setRue(rs.getString("nom"));
				utilisateur.setCodePostal(rs.getInt("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdmnistrateur(rs.getBoolean("administrateur"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public void insert(UtilisateurBO utilisateurs) throws BusinessException {
		if (utilisateurs == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultat.INSERT_OBJET_NULL);
			throw new BusinessException();
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, utilisateurs.getPseudo());
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
				businessException.ajouterErreur(CodesResultat.INSERT_UTILISATEUR_NOTE_ECHEC);
			} else {
				businessException.ajouterErreur(CodesResultat.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}
	}

	public void UtilisateurBO() {
		// TODO Auto-generated method stub

	}

}
