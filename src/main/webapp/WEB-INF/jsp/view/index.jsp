<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Application</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">


</head>
<body>
	<div class="container p-5">

		<div>
			<h3 class="my-4"> Gestion d’absence des étudiants de ENSAH </h3>
			<ul>
			<li>Gestion des étudiants</li>
			<li>Authentification et gestion des habilitations</li>
			<li>Gestion de la structure pédagogique</li>
			<li>Gestion des comptes</li>
			<li>Gestion des absences</li>
			</ul>
			
		</div>
		<div>
		

			<p>Connecter avec votre compte pour accéder à l'application</p>
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/showMyLoginPage"> Connection </a>
		</div>


	</div>
</body>
</html>