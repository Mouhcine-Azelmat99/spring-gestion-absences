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



<%--    <div>--%>
<%--        <c:if test="${inscriptionList.niveau !=null}">--%>
<%--            <h3>Les etudiants de la class ${inscriptionList.niveau.titre}</h3>--%>
<%--        </c:if>--%>
<%--    </div>--%>

        <div class="row">
            <div class="col-3">
                <ul>
                    <li><a class="btn btn-link" href="${pageContext.request.contextPath}/admin/etudiants/">Touts les etudiants</a></li>
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

                <c:forEach items="${inscriptionList}" var="p">
                    <tr>
                        <td><c:out value="${p.etudiant.cne}" /></td>
                        <td><c:out value="${p.etudiant.cin}" /></td>
                        <td><c:out value="${p.etudiant.nom} / ${p.etudiant.nomArabe}" /></td>
                        <td><c:out value="${p.etudiant.prenom} / ${p.etudiant.prenomArabe}" /></td>
                        <td><c:out value="${p.etudiant.email}" /></td>
                        <td><c:out value="${p.etudiant.telephone}" /></td>

                        <td>
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/admin/deletePerson/${p.etudiant.idUtilisateur}">Delete</a></li>

                                <li><a href="${pageContext.request.contextPath}/admin/updatePersonForm/${p.etudiant.idUtilisateur}">Update</a></li>
                            </ul>
                        </td>

                    </tr>

                </c:forEach>

            </table>
            </div>
        </div>

<jsp:include page="../fragments/adminfooter.jsp" />