<%@page import="com.mouhcine.SchoolSpringApp.web.models.PersonModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/adminHeader.jsp" />


<div class="container">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">

            <jsp:include page="../fragments/menu.jsp" />

        </div>
    </nav>
    <h3 class="my-5">Les inscriptions</h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Etudiant</th>
            <th scope="col">Niveau</th>
            <th scope="col">Annee</th>
            <th scope="col">Etat</th>
        </tr>
        </thead>

        <c:forEach items="${inscriptionsList}" var="p">
            <tr>
                <td><c:out value="${p.idInscription}" /></td>
                <td><c:out value="${p.etudiant.nom}" /> - <c:out value="${p.etudiant.prenom}" /></td>
                <td><c:out value="${p.niveau.titre}" /></td>
                <td><c:out value="${p.annee}" /></td>
                <td><c:out value="${p.etat}" /></td>
            </tr>

        </c:forEach>

    </table>

<jsp:include page="../fragments/adminfooter.jsp" />
    </div>
