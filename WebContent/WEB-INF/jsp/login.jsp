<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
<h1>Eni-Enchères</h1>
<form method="post" action="traitement.php">
   <p>
       <label for="pseudo">Votre pseudo :</label>
       <input type="text" name="pseudo" id="pseudo" />
       
       <br />
       <label for="pass">Votre mot de passe :</label>
       <input type="password" name="pass" id="pass" />
       <br />
      <br />
       <input type="submit" value="Connexion" />
       
       <input type="checkbox" name="souvenirdemoi" id="souvenirdemoi" /><label for="souvenirdemoi">Se souvenir de moi</label>
       <br />
       <label for="mdpoublie"><a href="#">Mot de passe oublié</a></label>
         <br />
        <br />
       <a href="#" ><input type="submit" value ="Créer un compte" /></a></p>
</form>
</body>
</html>