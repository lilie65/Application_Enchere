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
	<form method="post" action="ConnexionServlet">
		<div id="formulaire">
			<fieldset>
				<legend>Connexion</legend>
				<p>Vous pouvez vous connecter via ce formulaire.</p>
				<div class="flexbox">
					<div class="orientation">
						<label for="identifiant">Votre Identifiant <span
							class="requis">*</span></label>
					</div>
					<div class="orientation">
						<input type="text" id="identifiant" name="identifiant"
							value="<c:out value="${utilisateur.identifiant}"/>" size="20"
							maxlength="60" /><span class="erreur"></span>
					</div>
				</div>
				<div class="flexbox">
					<div class="orientation">
						<label for="motdepasse">Mot de passe<span class="requis">
								*</span>
						</label>
					</div>
					<div class="orientation">
						<input type="password" id="motdepasse" name="motdepasse" value=""
							size="20" maxlength="20" /><span class="erreur"></span>
					</div>
				</div>
				<div class="flexbox">
					<div class="orientation">
						<input class="button" type="submit" value="Connexion"
							class="sansLabel" />
					</div>
					<div class="orientation ">
						<input type="checkbox" cols="1"/>
						<option valeur="other">Se souvenir de moi</option>
					</div>
				</div>
				<div class="flexbox">
					<div class="orientation">
						<a href="./inscriptionUtilisateur" class="sansLabel"
							name="inscription"><input class="button" type="button"
							value="inscription " /></a>
					</div>
					<div class="orientation">
						<a href="/Web-inf/jsp/passOublier.jsp">Mot de passe oublié</a>
					</div>
				</div>
				<c:out value="${error}" />
			</fieldset>
		</div>
	</form>
</body>
</html>