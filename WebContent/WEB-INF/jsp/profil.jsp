<%@page import="fr.eni.application.enchere.messages.LectureMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.application.enchere.bo.UtilisateurBO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:mso="urn:schemas-microsoft-com:office:office"
	xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">

<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Mon profil</title>
</head>

<body>
	<h1>Eni-Enchères</h1>

	<h2>Mon profil</h2>
	<%
			UtilisateurBO utilisateurBO = (UtilisateurBO) request.getAttribute("utilisateurBO");
		if (utilisateurBO != null) {
	%>
		<p style="color: red;">L'avis a été ajouté avec succès :</p>
		<p><%=utilisateurBO%></p>
	<%
		}
	%>

	<%
			List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
		if (listeCodesErreur != null) {
	%>
		<p style="color: red;">Erreur, l'avis n'a pas pu être ajouté :</p>
	<%
		for (int codeErreur : listeCodesErreur) {
	%>
		<p><%=LectureMessage.getMessageErreur(codeErreur)%></p>
	<%
		}
	}
	%>
	<form method="post" action="inscriptionUtilisateur" method="post">
		<div id="formulaire">
			<div class="flexbox">
				<div class="orientation">
					<label for="pseudo">Votre pseudo :</label>
				</div>
				<div class="orientation">
					<input type="text" name="pseudo" id="pseudo" size="20"
						value="<%=listeCodesErreur != null ? request.getParameter("pseudo") : ""%> " />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="nom">Nom :</label>
				</div>
				<div class="orientation">
					<input type="text" name="nom" id="nom" size="20"
						value="<%=listeCodesErreur != null ? request.getParameter("nom") : ""%>" />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="prenom">Prénom :</label>
				</div>
				<div class="orientation">
					<input type="text" name="prenom" id="prenom" size="20"
						<%=listeCodesErreur != null ? request.getParameter("prenom") : ""%> />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="email">Email :</label>
				</div>
				<div class="orientation">
					<input type="email" name="email" id="email" size="20" />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="tel">Téléphone :</label>
				</div>
				<div class="orientation">
					<input type="number" name="telephone" id="tel" size="20"
						<%=listeCodesErreur != null ? request.getParameter("telephone") : ""%> />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="rue">Rue :</label>
				</div>
				<div class="orientation">
					<input type="text" name="rue" id="rue" size="20"
						<%=listeCodesErreur != null ? request.getParameter("rue") : ""%> />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="codepostal">Code postal :</label>
				</div>
				<div class="orientation">
					<input type="text" name="code_postal" id="codepostal" size="20"
						<%=listeCodesErreur != null ? request.getParameter("code_postal") : ""%> />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="ville">Ville :</label>
				</div>
				<div class="orientation">
					<input type="text" name="ville" id="ville" size="20"
						<%=listeCodesErreur != null ? request.getParameter("ville") : ""%> />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="pass">Mot de passe :</label>
				</div>
				<div class="orientation">
					<input type="password" name="mot_de_passe" id="pass" size="20"
						<%=listeCodesErreur != null ? request.getParameter("mot_de_passe") : ""%> />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="confirmation">Confirmation :</label>
				</div>
				<div class="orientation">
					<input type="password" name="confirmation" id="confirmation" />
				</div>
			</div>
			<div class="flexbox">
				<a href="pageAchat.jsp"><input class="button" type="submit"
					value="Créer" /></a>
			</div>
			<div class="flexbox">
				<a href="#"><input class="button" type="submit" value="Annuler" /></a>
			</div>
		</div>
	</form>
</body>
</html>