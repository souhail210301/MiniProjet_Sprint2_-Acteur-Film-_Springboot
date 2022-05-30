<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste Acteurs</title>
</head>
<body>
<div class="container mt-5">
<div class="card">
 <div class="card-header">
 Liste des Acteurs
 </div>
 <div class="card-body">
 
 <table class="table table-striped">
 <tr>
<th>ID</th><th>Nom Acteur</th><th>Salaire</th><th>Date 
Naissance</th><th>Suppression<th>Edition</th>
 </tr>
 <c:forEach items="${acteurs}" var="a">
 <tr>
 <td>${a.idActeur}</td>
 <td>${a.nomActeur}</td>
 <td>${a.salaireActeur}</td>
 <td><fmt:formatDate pattern="dd/MM/yyyy"
value="${a.dateNaissance}" /></td>
 <td><a onclick="return confirm('Etes-vous sur ?')"
href="supprimerActeur?id=${a.idActeur }">Supprimer</a></td>
 <td><a href="modifierActeur?id=${a.idActeur }">Edit</a></td>
 </tr>
 </c:forEach> 
 </table>
 </div>
</div>
</div>
</body>
</html>
