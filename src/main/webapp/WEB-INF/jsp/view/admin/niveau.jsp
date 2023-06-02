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
        <h3>Gestion des Niveaux</h3>
    </div>

    <div>
        <c:if test="${msg}">
            <div class="alert alert-success col-6">${msg}</div>
        </c:if>

        <f:form action="addNiveau" method="POST"  modelAttribute="niveauModel">
            <f:input type="text" class="form-control"
                     placeholder="alias Niveau" path="alias"/>
            <f:input type="text" class="form-control"
                     placeholder="titre Niveau" path="titre"/>
            <f:select path="filiere" multiple="false" size="1" class="form-control">
                <f:options items="${filieresList}" itemValue="idFiliere" itemLabel="titreFiliere" />
            </f:select>
            <button class="btn btn-primary" type="submit">Submit</button>
        </f:form>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">idNiveau</th>
                <th scope="col">alias</th>
                <th scope="col">titre</th>
                <th scope="col">filiere</th>
                <th scope="col">modules</th>
                <th scope="col">Action</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${niveauxList}" var="a">
                <tr>
                    <td><c:out value="${a.idNiveau}" /></td>
                    <td><c:out value="${a.alias}" /></td>
                    <td><c:out value="${a.titre}" /></td>
                    <td><c:out value="${a.filiere.titreFiliere}" /></td>
                    <td>
                        <c:forEach items="${a.modules}" var="module">
                            ${module.titre} -
                        </c:forEach>
                    </td>
                    <td>
                    <form action="deleteniveau" method="post">
                        <input type="hidden" name="idNiveau" value="${a.idNiveau}">
                        <button class="btn btn-danger">Supprimer</button>
                    </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<jsp:include page="../fragments/adminfooter.jsp" />