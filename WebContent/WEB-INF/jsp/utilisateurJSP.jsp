<%@page import="com.mysql.cj.Session"%>
<%@page import="fr.eni.application.enchere.bo.UtilisateurBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Mes informations</title>
</head>
<body>
	<header class="flex">
		<img class="logo" alt="logo" src="images/logo.png">
		<h1>Eni-Enchères</h1>
	</header>
	<%
		UtilisateurBO utilisateur = (UtilisateurBO) session.getAttribute("sessionUtilisateur");
	%>
	<article>
		<h2>Mon profil</h2>

		<div class="form">
		<div class="column border">
			<div class="flexbox ">
				<h3>Nom de l'utilisateur :
					<%=utilisateur.getNom()%>
				</h3>
			</div>
			<div class="flexbox">
				<h3>Prénom de l'utilisateur :
					<%=utilisateur.getPrenom()%>
				</h3>
			</div>
			<div class="flexbox">
				<h3>pseudo de l'utilisateur :
					<%=utilisateur.getPseudo()%>
				</h3>
			</div>
			<div class="flexbox">
				<h3>Rue de l'utilisateur :
					<%=utilisateur.getRue()%>
				</h3>
			</div>
			<div class="flexbox">
				<h3>Code postal de l'utilisateur :
					<%=utilisateur.getCodePostal()%>
				</h3>
			</div>
			<div class="flexbox">
				<h3>Ville de l'utilisateur :
					<%=utilisateur.getVille()%>
				</h3>
			</div>
			<div class="flexbox">
				<h3>Téléphone de l'utilisateur :
					<%=utilisateur.getTelephone()%>
				</h3>
			</div>
			<div class="flexbox">
				<h3>Email de l'utilisateur :
					<%=utilisateur.getEmail()%>
				</h3>
			</div>
			<div class="flexbox">
				<h3>
					Credit de l'utilisateur :
					<%=utilisateur.getCredit()%>
				</h3>
			</div>
		</div>
</div>
	</article>
	<footer>
		<a class="legale" href="mention_legale.html"/>Mention légale</a>
	</footer>
</body>
</html>