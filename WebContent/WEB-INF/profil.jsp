<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>Monprofil</title>
</head>

<body>
	<h1>Eni-Enchères</h1>

	<h2>Mon profil</h2>

	<div id="formulaire">
		<div class="flexbox">
			<div class="orientation">
				<label for="pseudo">Votre pseudo :</label> <input type="text"
					name="pseudo" id="pseudo" />
			</div>
			<div class="orientation">
				<label for="prenom">Prénom :</label> <input type="text"
					name="prenom" id="prenom" />
			</div>
			<div class="orientation">
				<label for="tel">Téléphone :</label> <input type="number" name="tel"
					id="tel" />
			</div>
			<div class="orientation">
				<label for="codepostal">Code postal :</label> <input type="text"
					name="codepostal" id="codepostal" />
			</div>
			<div class="orientation">
				<label for="pass">Mot de passe :</label> <input type="password"
					name="pass" id="pass" />
			</div>
		</div>



		<div class="flexbox">

			<label for="nom">Nom :</label> <input type="text" name="nom" id="nom" />
			<br /> <br /> <label for="email">Email :</label> <input
				type="email" name="email" id="email" /> <br /> <br /> <label
				for="rue">Rue :</label> <input type="text" name="rue" id="rue" /> <br />
			<br /> <label for="ville">Ville :</label> <input type="text"
				name="ville" id="ville" /> <br /> <br /> <label
				for="confirmation">Confirmation :</label> <input type="password"
				name="confirmation" id="confirmation" /> <br /> <br /> <br /> <a
				href="#"><input type="submit" value="Créer" /></a> <a href="#"><input
				type="submit" value="Annuler" /></a>


		</div>
	</div>
</body>
</html>