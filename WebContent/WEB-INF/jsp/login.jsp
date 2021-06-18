<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="fr.eni.application.enchere.bo.UtilisateurBO"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Login</title>
</head>
<body>
	<h1>Eni-Enchères</h1>
	<form method="post" action="connexionServlet">
		<fieldset>
			<legend>Connexion</legend>
			<p>Vous pouvez vous connecter via ce formulaire.</p>

			<label for="identifiant">Votre Identifiant <span class="requis">*</span></label>
			<input type="text" id="identifiant" name="identifiant"
				value="<c:out value="${utilisateur.email}"/>" size="20"
				maxlength="60" /> <span class="erreur">${form.erreurs['email']}</span>
			<br /> 
			<label for="motdepasse">Mot de passe <span class="requis">*</span></label> 
				<input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['motdepasse']}</span> <br /> 
				<input type="submit" value="Connexion" class="sansLabel" /> <br />

			<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
		</fieldset>
	</form>
	
</body>
</html>