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


    <div class="row">
        <div class="col-3">
            <ul>
                <c:forEach items="${niveauxList}" var="n">
                    <li><a class="btn btn-link" href="${pageContext.request.contextPath}/admin/etudiants/${n.idNiveau}">${n.titre}</a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="col-9">

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">CNE</th>
                    <th scope="col">CIN</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Prénom</th>
                    <th scope="col">Email</th>
                    <th scope="col">Télé</th>
                    <th>Actions</th>
                </tr>
                </thead>

                <c:forEach items="${etudiantsList}" var="p">
                    <tr>
                        <td><c:out value="${p.cne}" /></td>
                        <td><c:out value="${p.cin}" /></td>
                        <td><c:out value="${p.nom} / ${p.nomArabe}" /></td>
                        <td><c:out value="${p.prenom} / ${p.prenomArabe}" /></td>
                        <td><c:out value="${p.email}" /></td>
                        <td><c:out value="${p.telephone}" /></td>

                        <td>
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/admin/deletePerson/${p.idUtilisateur}">Delete</a></li>

                                <li><a href="${pageContext.request.contextPath}/admin/updatePersonForm/${p.idUtilisateur}">Update</a></li>
                            </ul>
                        </td>

                    </tr>

                </c:forEach>

            </table>
        </div>
    </div>

<jsp:include page="../fragments/adminfooter.jsp" />