<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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


    <div>
        <h3>Gestion des filiéres</h3>
    </div>

    <div>
        <c:if test="${msg}">
            <div class="alert alert-success col-6">${msg}</div>
        </c:if>

        <a href="addfiliere" class="btn btn-primary my-5">Ajouter un filiére</a>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Titre</th>
                <th scope="col">codeFiliere</th>
                <th scope="col">anneeaccreditation</th>
                <th scope="col">anneeFinaccreditation</th>
                <th scope="col">Coordinateur</th>
                <th scope="col">Niveaux</th>
                <th scope="col">Action</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${filiersList}" var="a">
                <tr>
                    <td><c:out value="${a.idFiliere}" /></td>
                    <td><c:out value="${a.titreFiliere}" /></td>
                    <td><c:out value="${a.codeFiliere}" /></td>
                    <td><c:out value="${a.anneeaccreditation}" /></td>
                    <td><c:out value="${a.anneeFinaccreditation}" /></td>
                    <td>
                        <c:forEach items="${a.coordinations}" var="coordination" varStatus="status">
                            <c:if test="${status.last}">${coordination.coordinateur.nom}</c:if>
                        </c:forEach>
                    </td><td>
                        <c:forEach items="${a.niveaux}" var="niveau">
                            ${niveau.alias} -
                        </c:forEach>
                    </td>
                    <td class="d-flex">
                    <form action="deletefiliere" method="post">
                        <input type="hidden" name="filiereId" value="${a.idFiliere}">
                        <button class="btn btn-danger mx-3">Supprimer</button>
                    </form>
                    <form action="filiere/coordinateur" method="get">
                        <input type="hidden" name="filiereId" value="${a.idFiliere}">
                        <button class="btn btn-primary mx-3">Affecter un Coordinateur</button>
                    </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<jsp:include page="../fragments/adminfooter.jsp" />