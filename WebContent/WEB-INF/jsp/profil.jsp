<%@page import="fr.eni.application.enchere.BusinessException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.application.enchere.bo.UtilisateurBO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//FR" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:mso="urn:schemas-microsoft-com:office:office"
	xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">

<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Mon profil</title>
</head>

<body>
	<header class="flex"> <img class="logo" alt="logo"
		src="images/logo.png">
	<h1>Eni-Enchères</h1>
	</header>
	<article>
	<h2>Mon profil</h2>
	
	<form class="form" method="post" action="inscriptionUtilisateur"
		method="post">
		<div id="formulaire" class="border">
			<div class="flexbox">
				<div class="orientation">
					<label for="pseudo">Votre pseudo :</label>
				</div>
				<div class="orientation">
					<input type="text" name="pseudo" id="pseudo" size="20" />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="nom">Nom :</label>
				</div>
				<div class="orientation">
					<input type="text" name="nom" id="nom" size="20" />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="prenom">Prénom :</label>
				</div>
				<div class="orientation">
					<input type="text" name="prenom" id="prenom" size="20" />
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
					<input type="tel" name="telephone" id="phone" size="20" />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="rue">Rue :</label>
				</div>
				<div class="orientation">
					<input type="text" name="rue" id="rue" size="20" />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="codepostal">Code postal :</label>
				</div>
				<div class="orientation">
					<input type="text" name="code_postal" id="codepostal" size="20" />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="ville">Ville :</label>
				</div>
				<div class="orientation">
					<input type="text" name="ville" id="ville" size="20" />
				</div>
			</div>
			<div class="flexbox">
				<div class="orientation">
					<label for="pass">Mot de passe :</label>
				</div>
				<div class="orientation">
					<input type="password" name="mot_de_passe" id="pass" size="20" />
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
					value="Créer" /></a> <a href="#"><input class="button"
					type="submit" value="Annuler" /></a>
			</div>
			<c:forEach items="${errors}" var="v">
			<c:out value="${error}">${v}</c:out>
			<br>
		</c:forEach>
		</div>
	</form> 
	</article>
	<footer> <a class="legale" href="mention_legale.html" />Mention
	légale</a> </footer>
</body>
</html>