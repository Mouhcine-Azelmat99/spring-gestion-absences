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
        <h3>Gestion des Modules</h3>
    </div>

    <div>
        <c:if test="${msg}">
            <div class="alert alert-success col-6">${msg}</div>
        </c:if>

        <f:form action="addModule" method="POST"  modelAttribute="moduleModel">
            <f:input type="text" class="form-control"
                     placeholder="titre Module" path="titre"/>
            <f:input type="text" class="form-control"
                     placeholder="code Module" path="code"/>
            <f:select path="niveau" multiple="false" size="1" class="form-control">
                <f:options items="${niveauxList}" itemValue="idNiveau" itemLabel="titre" />
            </f:select>
            <button class="btn btn-primary" type="submit">Submit</button>
        </f:form>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">idModule</th>
                <th scope="col">titre</th>
                <th scope="col">code</th>
                <th scope="col">elements</th>
                <th scope="col">niveau</th>
                <th scope="col">Action</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${modulesList}" var="a">
                <tr>
                    <td><c:out value="${a.idModule}" /></td>
                    <td><c:out value="${a.titre}" /></td>
                    <td><c:out value="${a.code}" /></td>
                    <td><c:out value="${a.elements}" /></td>
                    <td><c:out value="${a.niveau.alias}" /></td>
                    <td>
                    <form action="deletemodule" method="post">
                        <input type="hidden" name="idModule" value="${a.idModule}">
                        <button class="btn btn-danger">Supprimer</button>
                    </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<jsp:include page="../fragments/adminfooter.jsp" />