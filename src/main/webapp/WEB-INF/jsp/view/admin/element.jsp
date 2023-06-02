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
        <h3>Gestion des Elements</h3>
    </div>

    <div>
        <c:if test="${msg}">
            <div class="alert alert-success col-6">${msg}</div>
        </c:if>

        <f:form action="addElement" method="POST"  modelAttribute="elementModel">
            <f:input type="text" class="form-control"
                     placeholder="nom Element" path="nom"/>
            <f:input type="text" class="form-control"
                     placeholder="code Element" path="code"/>
            <f:input type="number" class="form-control"
                     placeholder="code Element" path="currentCoefficient"/>
            <f:select path="module" multiple="false" size="1" class="form-control">
                <f:options items="${modulesList}" itemValue="idModule" itemLabel="titre" />
            </f:select>
            <button class="btn btn-primary" type="submit">Submit</button>
        </f:form>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">idMatiere</th>
                <th scope="col">nom</th>
                <th scope="col">code</th>
                <th scope="col">currentCoefficient</th>
                <th scope="col">module</th>
                <th scope="col">Action</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${elementsList}" var="a">
                <tr>
                    <td><c:out value="${a.idMatiere}" /></td>
                    <td><c:out value="${a.nom}" /></td>
                    <td><c:out value="${a.code}" /></td>
                    <td><c:out value="${a.currentCoefficient}" /></td>
                    <td><c:out value="${a.module.titre}" /></td>
                    <td>
                    <form action="deleteelement" method="post">
                        <input type="hidden" name="idMatiere" value="${a.idMatiere}">
                        <button class="btn btn-danger">Supprimer</button>
                    </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<jsp:include page="../fragments/adminfooter.jsp" />