<%@page import="com.mysql.cj.Session"%>
<%@page import="fr.eni.application.enchere.bo.UtilisateurBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Mon utilisateur</title>
</head>
<body>

	<%
		
		UtilisateurBO utilisateur = (UtilisateurBO) request.getAttribute("utilisateur");
	%>

	<h2>L'utilisateur :</h2>
	
	<p>
		Nom de l'utilisateur :
		<%=utilisateur.getNom()%>
	</p>
	<p>
		Prénom de l'utilisateur :
		<%=utilisateur.getPrenom()%>
	</p>
	<p>
		pseudo de l'utilisateur :
		<%=utilisateur.getPseudo()%>
	</p>
	<p>
		Rue de l'utilisateur :
		<%=utilisateur.getRue()%>
	</p>
	<p>
		Code postal de l'utilisateur :
		<%=utilisateur.getCodePostal()%>
	</p>
	<p>
		Ville de l'utilisateur :
		<%=utilisateur.getVille()%>
	</p>
	<p>
		Téléphone de l'utilisateur :
		<%=utilisateur.getTelephone()%>
	</p>
	<p>
		Email de l'utilisateur :
		<%=utilisateur.getEmail()%>
	</p>
	<p>
		Credit de l'utilisateur :
		<%=utilisateur.getCredit()%>
	</p>
</body>
</html>