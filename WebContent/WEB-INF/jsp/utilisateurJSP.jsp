<%@page import="fr.eni.application.enchere.bo.Utilisateur"%>
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
		Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
	%>
<h2>L'utilisateur :</h2>
<p>
	<%=
		utilisateur.getNom()
	%>
</body>
</html>