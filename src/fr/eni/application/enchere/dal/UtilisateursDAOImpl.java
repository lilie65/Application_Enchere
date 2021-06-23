package fr.eni.application.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.application.enchere.BusinessException;
import fr.eni.application.enchere.bo.UtilisateurBO;

public class UtilisateursDAOImpl implements UtilisateursDAO {
	private static final String INSERT = "INSERT INTO utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	private static final String SELECT = "select no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur from utilisateurs where no_utilisateur= ?";
	private static final String verifConnection = "select no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,credit,administrateur from utilisateurs where (pseudo = ? or email = ?) AND mot_de_passe = ?";

	@Override
	public UtilisateurBO select(int idUtilisateur) throws BusinessException {

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
			pstmt.setBoolean(11, utilisateurs.isAdmnistrateur());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				utilisateurs.setNoUtilisateur(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("CK_AVIS_note")) {
				businessException.ajouterErreur("Insertion de l'utilisateur impossible");
			} else {
				businessException.ajouterErreur("Echec objet nulle");
			}
			throw businessException;
		}
	}

	public void UtilisateurBO() {
		// TODO Auto-generated method stub

	}

	@Override
	public UtilisateurBO verifConnection(String pseudoEmail, String mdp) throws BusinessException {
		UtilisateurBO utilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {

			java.sql.PreparedStatement pstmt = cnx.prepareStatement(verifConnection);
			pstmt.setString(1, pseudoEmail);
			pstmt.setString(2, pseudoEmail);
			pstmt.setString(3, mdp);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				utilisateur = new UtilisateurBO();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getInt("telephone"));
				utilisateur.setRue(rs.getString("nom"));
				utilisateur.setCodePostal(rs.getInt("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdmnistrateur(rs.getBoolean("administrateur"));
			} else {
				BusinessException be = new BusinessException();
				be.ajouterErreur("Utilisateur non reconnue");
			}
		} catch (Exception e) {
			BusinessException be = new BusinessException();
			be.ajouterErreur("erreur base de données");

		}
		BusinessException businessException = new BusinessException();
		// definir si c'est un pseudo ou un mail

		return utilisateur;
	}

}
